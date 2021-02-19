package POO.game.classes;

import java.util.Vector;

public abstract class Personnage {
	
	protected String nom;
	protected int endurance;
	protected int force;
	protected int pointsVie;
	protected int pointsVieTotal;
	protected De monDe;
	protected boolean estMort;
	protected boolean vaAttaquer;
	protected int x, y;
	
	public int getPointsVieTotal() {
		return pointsVieTotal;
	}
	public int getEndurance() {
		return endurance;
	}
	public int getForce() {
		return force;
	}
	public int getPointsVie() {
		return pointsVie;
	}
	
	protected int calculerStatDemarrage(int[] elem) {
		boolean estOrdonne = false;
		int taille = elem.length;
		int sortie = 0;
		while(!estOrdonne) {
			estOrdonne = true;
			for(int i = 0;i<taille - 1; i++) {
				if(elem[i] > elem[i+1]) {
					int temp = elem[i+1];
					elem[i+1] = elem[i];
					elem[i] = temp;
					estOrdonne = false;
				}
			}
			taille--;
		}
		elem[0] = 0;
		
		for(int i : elem) {
			sortie+=i;
		}
		
		return sortie;
		
	}
	
	protected int[] creerValeurs() {
		int[] ValeursDes = new int[4];
		
		for(int i=0; i<ValeursDes.length; i++) {
			ValeursDes[i] = monDe.lance(7);
		}
		return ValeursDes;
	}

	protected int calculerModificateur(int valeur) {
		
		
			if(valeur < 5) {
				valeur=-1;
			}else if(valeur < 10) {
				valeur= 0;
			}else if(valeur < 15) {
				valeur=1;
			}else {
				valeur=2;
			}
		
		return valeur;
	}

	protected void frappe(Personnage cible) {
		int degat;
		String temp = this.getClass().getSimpleName();
		String temp1 = cible.getClass().getSimpleName();
		
		if(temp.equalsIgnoreCase("Humain") || temp.equalsIgnoreCase("Nain")) {
			Heros hero = (Heros)this;
			degat = monDe.lance(5) + calculerModificateur(hero.getForce()+hero.forceBonus);
		
		}else {
			Monstre mechant = (Monstre)this;
			degat = monDe.lance(5) + calculerModificateur(mechant.getForce()+mechant.forceBonus);
		}
		System.out.printf("\n%13s frappe %13s avec %2d DEG\n",this.getClass().getSimpleName(), cible.getClass().getSimpleName(), degat);
		
		cible.pointsVie -= degat;
		
		if(cible.pointsVie <= 0) {
			cible.mort();
		}
		
		if(temp1.equalsIgnoreCase("Loup") || temp1.equalsIgnoreCase("Dragonnet") || temp1.equalsIgnoreCase("Orque")) {
			Monstre monstre = (Monstre)cible;
			monstre.afficherInfo();
		}else {
			Heros hero = (Heros)cible;
			hero.afficherInfo();
		}
			
	}

	protected void mort() {
		this.estMort = true;
		System.out.printf("\n%40s a succomb� de ses blessures !!!\n\n", this.getClass().getSimpleName());
	}
	
	public String afficherPersonnage() {
		String sortie = "";
		if(this.estMort) {
			return "X";
		}else {
			switch(this.getClass().getSimpleName()) {
			case "Loup" : 
				sortie = "L";
				break;
			case "Orque" : 
				sortie = "O";
				break;
			case "Dragonnet" :
				sortie = "D";
				break;
			case "Humain" :
				sortie = "H";
				break;
			case "Nain" :
				sortie = "N";
				break;
			}
			
			return sortie;
		}
		
		
			
	}

	protected void seDeplace(Terrain monTerrain) {
		
		for(Vector<Case> v : monTerrain.getGrille()) {
			for(Case c : v) {
				if(c.getPersonnage() != null) {
					if(c.getPersonnage().nom.equalsIgnoreCase(this.nom)) {
						this.x = c.getX();
						this.y = c.getY();
						c.ajouterPersonnage(null);
						System.out.print(nom +' '+x+' '+y+'\n');
					}
				}
			}
		}
		if(this.x >= 1 && this.x <= 13) {
			if(this.y >= 1 && this.y <= 13) {
				//	peut se d�placer dans les 4 directions
				switch(monDe.lanceZero(4)) {
				case 0 :
					if(monTerrain.getGrille().elementAt(x+1).elementAt(y).isEstVide()) {
						monTerrain.getGrille().elementAt(x+1).elementAt(y).ajouterPersonnage(this);
					}else {
						// combat
			//			System.out.println("Debut du combat");
//						monTerrain.getGrille().elementAt(x).elementAt(y).ajouterPersonnage(this);
						if(monTerrain.getGrille().elementAt(x+1).elementAt(y).getPersonnage() != null) {
							if(!monTerrain.getGrille().elementAt(x+1).elementAt(y).getPersonnage().getClass().getSimpleName().equalsIgnoreCase("Humain") && !monTerrain.getGrille().elementAt(x+1).elementAt(y).getPersonnage().getClass().getSimpleName().equalsIgnoreCase("Nain") ) {
								this.vaAttaquer = true;
							}
						}
					}
					break;
				case 1 :
					if(monTerrain.getGrille().elementAt(x-1).elementAt(y).isEstVide()) {
						monTerrain.getGrille().elementAt(x-1).elementAt(y).ajouterPersonnage(this);
					}else {
						// combat
//						monTerrain.getGrille().elementAt(x).elementAt(y).ajouterPersonnage(this);
						if(monTerrain.getGrille().elementAt(x-1).elementAt(y).getPersonnage() != null) {
							if(!monTerrain.getGrille().elementAt(x-1).elementAt(y).getPersonnage().getClass().getSimpleName().equalsIgnoreCase("Humain") && !monTerrain.getGrille().elementAt(x-1).elementAt(y).getPersonnage().getClass().getSimpleName().equalsIgnoreCase("Nain") ) {
								this.vaAttaquer = true;
							}
						}
					}
					break;
				case 2 : 
					if(monTerrain.getGrille().elementAt(x).elementAt(y+1).isEstVide()) {
						monTerrain.getGrille().elementAt(x).elementAt(y+1).ajouterPersonnage(this);
					}else {
						// combat
//						monTerrain.getGrille().elementAt(x).elementAt(y).ajouterPersonnage(this);
						if(monTerrain.getGrille().elementAt(x).elementAt(y+1).getPersonnage() != null) {
							if(!monTerrain.getGrille().elementAt(x).elementAt(y+1).getPersonnage().getClass().getSimpleName().equalsIgnoreCase("Humain") && !monTerrain.getGrille().elementAt(x).elementAt(y+1).getPersonnage().getClass().getSimpleName().equalsIgnoreCase("Nain") ) {
								this.vaAttaquer = true;
							}
						}
					}
					break;
				case 3 :
					if(monTerrain.getGrille().elementAt(x).elementAt(y-1).isEstVide()) {
						monTerrain.getGrille().elementAt(x).elementAt(y-1).ajouterPersonnage(this);
					}else {
						// combat
//						monTerrain.getGrille().elementAt(x).elementAt(y).ajouterPersonnage(this);
						if(monTerrain.getGrille().elementAt(x).elementAt(y-1).getPersonnage() != null) {
							if(!monTerrain.getGrille().elementAt(x).elementAt(y-1).getPersonnage().getClass().getSimpleName().equalsIgnoreCase("Humain") && !monTerrain.getGrille().elementAt(x).elementAt(y-1).getPersonnage().getClass().getSimpleName().equalsIgnoreCase("Nain") ) {
								this.vaAttaquer = true;
							}
						}
					}
					break;
				}
			}else if(this.y == 0){
				// ne peut pas se d�placer � gauche
				switch(monDe.lanceZero(3)) {
				case 0 :
					if(monTerrain.getGrille().elementAt(x+1).elementAt(y).isEstVide()) {
						monTerrain.getGrille().elementAt(x+1).elementAt(y).ajouterPersonnage(this);
						
					}else {
						// combat
//						monTerrain.getGrille().elementAt(x).elementAt(y).ajouterPersonnage(this);
						if(monTerrain.getGrille().elementAt(x+1).elementAt(y).getPersonnage() != null) {
							if(!monTerrain.getGrille().elementAt(x+1).elementAt(y).getPersonnage().getClass().getSimpleName().equalsIgnoreCase("Humain") && !monTerrain.getGrille().elementAt(x+1).elementAt(y).getPersonnage().getClass().getSimpleName().equalsIgnoreCase("Nain") ) {
								this.vaAttaquer = true;
							}
						}
					}
					break;
				case 1 : 
					if(monTerrain.getGrille().elementAt(x).elementAt(y+1).isEstVide()) {
						monTerrain.getGrille().elementAt(x).elementAt(y+1).ajouterPersonnage(this);
					}else {
						// combat
//						monTerrain.getGrille().elementAt(x).elementAt(y).ajouterPersonnage(this);
						if(monTerrain.getGrille().elementAt(x).elementAt(y+1).getPersonnage() != null) {
							if(!monTerrain.getGrille().elementAt(x).elementAt(y+1).getPersonnage().getClass().getSimpleName().equalsIgnoreCase("Humain") && !monTerrain.getGrille().elementAt(x).elementAt(y+1).getPersonnage().getClass().getSimpleName().equalsIgnoreCase("Nain") ) {
								this.vaAttaquer = true;
							}
						}
					}
					break;
				case 2 :
					if(monTerrain.getGrille().elementAt(x-1).elementAt(y).isEstVide()) {
						monTerrain.getGrille().elementAt(x-1).elementAt(y).ajouterPersonnage(this);
					}else {
						// combat
//						monTerrain.getGrille().elementAt(x).elementAt(y).ajouterPersonnage(this);
						if(monTerrain.getGrille().elementAt(x-1).elementAt(y).getPersonnage() != null) {
							if(!monTerrain.getGrille().elementAt(x-1).elementAt(y).getPersonnage().getClass().getSimpleName().equalsIgnoreCase("Humain") && !monTerrain.getGrille().elementAt(x-1).elementAt(y).getPersonnage().getClass().getSimpleName().equalsIgnoreCase("Nain") ) {
								this.vaAttaquer = true;
							}
						}
					}
					break;
				}
			}else if(this.y == 14) {
				// ne peut pas se d�placer � droite
				switch(monDe.lanceZero(3)) {
				case 0 :
					if(monTerrain.getGrille().elementAt(x+1).elementAt(y).isEstVide()) {
						monTerrain.getGrille().elementAt(x+1).elementAt(y).ajouterPersonnage(this);
					}else {
						// combat
//						monTerrain.getGrille().elementAt(x).elementAt(y).ajouterPersonnage(this);
						if(monTerrain.getGrille().elementAt(x+1).elementAt(y).getPersonnage() != null) {
							if(!monTerrain.getGrille().elementAt(x+1).elementAt(y).getPersonnage().getClass().getSimpleName().equalsIgnoreCase("Humain") && !monTerrain.getGrille().elementAt(x+1).elementAt(y).getPersonnage().getClass().getSimpleName().equalsIgnoreCase("Nain") ) {
								this.vaAttaquer = true;
							}
						}
					}
					break;
				case 1 :
					if(monTerrain.getGrille().elementAt(x-1).elementAt(y).isEstVide()) {
						monTerrain.getGrille().elementAt(x-1).elementAt(y).ajouterPersonnage(this);
						
					}else {
						// combat
//						monTerrain.getGrille().elementAt(x).elementAt(y).ajouterPersonnage(this);
						if(monTerrain.getGrille().elementAt(x-1).elementAt(y).getPersonnage() != null) {
							if(!monTerrain.getGrille().elementAt(x-1).elementAt(y).getPersonnage().getClass().getSimpleName().equalsIgnoreCase("Humain") && !monTerrain.getGrille().elementAt(x-1).elementAt(y).getPersonnage().getClass().getSimpleName().equalsIgnoreCase("Nain") ) {
								this.vaAttaquer = true;
							}
						}
					}
					break;
				case 2 :
					if(monTerrain.getGrille().elementAt(x).elementAt(y-1).isEstVide()) {
						monTerrain.getGrille().elementAt(x).elementAt(y-1).ajouterPersonnage(this);
					}else {
						// combat
//						monTerrain.getGrille().elementAt(x).elementAt(y).ajouterPersonnage(this);
						if(monTerrain.getGrille().elementAt(x).elementAt(y-1).getPersonnage() != null) {
							if(!monTerrain.getGrille().elementAt(x).elementAt(y-1).getPersonnage().getClass().getSimpleName().equalsIgnoreCase("Humain") && !monTerrain.getGrille().elementAt(x).elementAt(y-1).getPersonnage().getClass().getSimpleName().equalsIgnoreCase("Nain") ) {
								this.vaAttaquer = true;
							}
						}
					}
					break;
				}
			}
		}else if(this.x == 0) {
			if(this.y >= 1 && this.y <= 13) {
				// ne peut pas se d�placer en haut
				switch(monDe.lanceZero(3)) {
				case 0 :
					if(monTerrain.getGrille().elementAt(x+1).elementAt(y).isEstVide()) {
						monTerrain.getGrille().elementAt(x+1).elementAt(y).ajouterPersonnage(this);
					}else {
						// combat
//						monTerrain.getGrille().elementAt(x).elementAt(y).ajouterPersonnage(this);
						if(monTerrain.getGrille().elementAt(x+1).elementAt(y).getPersonnage() != null) {
							if(!monTerrain.getGrille().elementAt(x+1).elementAt(y).getPersonnage().getClass().getSimpleName().equalsIgnoreCase("Humain") && !monTerrain.getGrille().elementAt(x+1).elementAt(y).getPersonnage().getClass().getSimpleName().equalsIgnoreCase("Nain") ) {
								this.vaAttaquer = true;
							}
						}
					}
					break;
				case 1 : 
					if(monTerrain.getGrille().elementAt(x).elementAt(y+1).isEstVide()) {
						monTerrain.getGrille().elementAt(x).elementAt(y+1).ajouterPersonnage(this);
					}else {
						// combat
//						monTerrain.getGrille().elementAt(x).elementAt(y).ajouterPersonnage(this);
						if(monTerrain.getGrille().elementAt(x).elementAt(y+1).getPersonnage() != null) {
							if(!monTerrain.getGrille().elementAt(x).elementAt(y+1).getPersonnage().getClass().getSimpleName().equalsIgnoreCase("Humain") && !monTerrain.getGrille().elementAt(x).elementAt(y+1).getPersonnage().getClass().getSimpleName().equalsIgnoreCase("Nain") ) {
								this.vaAttaquer = true;
							}
						}
					}
					break;
				case 2 :
					if(monTerrain.getGrille().elementAt(x).elementAt(y-1).isEstVide()) {
						monTerrain.getGrille().elementAt(x).elementAt(y-1).ajouterPersonnage(this);
					}else {
						// combat
//						monTerrain.getGrille().elementAt(x).elementAt(y).ajouterPersonnage(this);
						if(monTerrain.getGrille().elementAt(x).elementAt(y-1).getPersonnage() != null) {
							if(!monTerrain.getGrille().elementAt(x).elementAt(y-1).getPersonnage().getClass().getSimpleName().equalsIgnoreCase("Humain") && !monTerrain.getGrille().elementAt(x).elementAt(y-1).getPersonnage().getClass().getSimpleName().equalsIgnoreCase("Nain") ) {
								this.vaAttaquer = true;
							}
						}
					}
						break;
				}
			}else if(this.y == 0) {
				//	ne peut pas se d�placer en haut et gauche
				switch(monDe.lanceZero(2)) {
				case 0 :
					if(monTerrain.getGrille().elementAt(x+1).elementAt(y).isEstVide()) {
						monTerrain.getGrille().elementAt(x+1).elementAt(y).ajouterPersonnage(this);
					}else {
						// combat
//						monTerrain.getGrille().elementAt(x).elementAt(y).ajouterPersonnage(this);
						if(monTerrain.getGrille().elementAt(x+1).elementAt(y).getPersonnage() != null) {
							if(!monTerrain.getGrille().elementAt(x+1).elementAt(y).getPersonnage().getClass().getSimpleName().equalsIgnoreCase("Humain") && !monTerrain.getGrille().elementAt(x+1).elementAt(y).getPersonnage().getClass().getSimpleName().equalsIgnoreCase("Nain") ) {
								this.vaAttaquer = true;
							}
						}
					}
					break;
				case 1 :
					if(monTerrain.getGrille().elementAt(x).elementAt(y+1).isEstVide()) {
						monTerrain.getGrille().elementAt(x).elementAt(y+1).ajouterPersonnage(this);
					}else {
						// combat
//						monTerrain.getGrille().elementAt(x).elementAt(y).ajouterPersonnage(this);
						if(monTerrain.getGrille().elementAt(x).elementAt(y+1).getPersonnage() != null) {
							if(!monTerrain.getGrille().elementAt(x).elementAt(y+1).getPersonnage().getClass().getSimpleName().equalsIgnoreCase("Humain") && !monTerrain.getGrille().elementAt(x).elementAt(y+1).getPersonnage().getClass().getSimpleName().equalsIgnoreCase("Nain") ) {
								this.vaAttaquer = true;
							}
						}
					}
						break;
				}
				
			}else if(this.y == 14) {
				//	ne peut pas se d�placer en haut et droite
				switch(monDe.lanceZero(2)) {
				case 0 :
					if(monTerrain.getGrille().elementAt(x+1).elementAt(y).isEstVide()) {
						monTerrain.getGrille().elementAt(x+1).elementAt(y).ajouterPersonnage(this);
					}else {
						// combat
//						monTerrain.getGrille().elementAt(x+1).elementAt(y).ajouterPersonnage(this);
						if(monTerrain.getGrille().elementAt(x+1).elementAt(y).getPersonnage() != null) {
							if(!monTerrain.getGrille().elementAt(x+1).elementAt(y).getPersonnage().getClass().getSimpleName().equalsIgnoreCase("Humain") && !monTerrain.getGrille().elementAt(x+1).elementAt(y).getPersonnage().getClass().getSimpleName().equalsIgnoreCase("Nain") ) {
								this.vaAttaquer = true;
							}
						}
					}
					break;
				case 2 :
					if(monTerrain.getGrille().elementAt(x).elementAt(y-1).isEstVide()) {
						monTerrain.getGrille().elementAt(x).elementAt(y-1).ajouterPersonnage(this);
					}else {
					// combat
//						monTerrain.getGrille().elementAt(x).elementAt(y-1).ajouterPersonnage(this);
						if(monTerrain.getGrille().elementAt(x).elementAt(y-1).getPersonnage() != null) {
							if(!monTerrain.getGrille().elementAt(x).elementAt(y-1).getPersonnage().getClass().getSimpleName().equalsIgnoreCase("Humain") && !monTerrain.getGrille().elementAt(x).elementAt(y-1).getPersonnage().getClass().getSimpleName().equalsIgnoreCase("Nain") ) {
								this.vaAttaquer = true;
							}
						}
					}
					break;
				}
			}
		}else if(this.x == 14) {
			if(this.y >= 1 && this.y <= 13) {
				//	 ne peut pas se d�placer en bas
				switch(monDe.lanceZero(3)) {
				case 0 :
					if(monTerrain.getGrille().elementAt(x-1).elementAt(y).isEstVide()) {
						monTerrain.getGrille().elementAt(x-1).elementAt(y).ajouterPersonnage(this);
					}else {
						// combat
//						monTerrain.getGrille().elementAt(x).elementAt(y).ajouterPersonnage(this);
						if(monTerrain.getGrille().elementAt(x-1).elementAt(y).getPersonnage() != null) {
							if(!monTerrain.getGrille().elementAt(x-1).elementAt(y).getPersonnage().getClass().getSimpleName().equalsIgnoreCase("Humain") && !monTerrain.getGrille().elementAt(x-1).elementAt(y).getPersonnage().getClass().getSimpleName().equalsIgnoreCase("Nain") ) {
								this.vaAttaquer = true;
							}
						}
					}
					break;
				case 1 :
					if(monTerrain.getGrille().elementAt(x).elementAt(y+1).isEstVide()) {
						monTerrain.getGrille().elementAt(x).elementAt(y+1).ajouterPersonnage(this);
					}else {
						// combat
//						monTerrain.getGrille().elementAt(x).elementAt(y).ajouterPersonnage(this);
						if(monTerrain.getGrille().elementAt(x).elementAt(y+1).getPersonnage() != null) {
							if(!monTerrain.getGrille().elementAt(x).elementAt(y+1).getPersonnage().getClass().getSimpleName().equalsIgnoreCase("Humain") && !monTerrain.getGrille().elementAt(x).elementAt(y+1).getPersonnage().getClass().getSimpleName().equalsIgnoreCase("Nain") ) {
								this.vaAttaquer = true;
							}
						}
					}
					break;
				case 2 :
					if(monTerrain.getGrille().elementAt(x).elementAt(y-1).isEstVide()) {
						monTerrain.getGrille().elementAt(x).elementAt(y-1).ajouterPersonnage(this);
					}else {
						// combat
//						monTerrain.getGrille().elementAt(x).elementAt(y-1).ajouterPersonnage(this);
						if(monTerrain.getGrille().elementAt(x).elementAt(y-1).getPersonnage() != null) {
							if(!monTerrain.getGrille().elementAt(x).elementAt(y-1).getPersonnage().getClass().getSimpleName().equalsIgnoreCase("Humain") && !monTerrain.getGrille().elementAt(x).elementAt(y-1).getPersonnage().getClass().getSimpleName().equalsIgnoreCase("Nain") ) {
								this.vaAttaquer = true;
							}
						}
					}
					break;
				}
			}else if(this.y == 0) {
				// ne peut pas se d�placer en bas et gauche
				switch(monDe.lanceZero(2)) {
				
				case 0 :
					if(monTerrain.getGrille().elementAt(x-1).elementAt(y).isEstVide()) {
						monTerrain.getGrille().elementAt(x-1).elementAt(y).ajouterPersonnage(this);
					}else {
						// combat
//						monTerrain.getGrille().elementAt(x).elementAt(y).ajouterPersonnage(this);
						if(monTerrain.getGrille().elementAt(x-1).elementAt(y).getPersonnage() != null) {
							if(!monTerrain.getGrille().elementAt(x-1).elementAt(y).getPersonnage().getClass().getSimpleName().equalsIgnoreCase("Humain") && !monTerrain.getGrille().elementAt(x-1).elementAt(y).getPersonnage().getClass().getSimpleName().equalsIgnoreCase("Nain") ) {
								this.vaAttaquer = true;
							}
						}
					}
					break;
				case 1 :
					if(monTerrain.getGrille().elementAt(x).elementAt(y+1).isEstVide()) {
						monTerrain.getGrille().elementAt(x).elementAt(y+1).ajouterPersonnage(this);
					}else {
						// combat
//						monTerrain.getGrille().elementAt(x).elementAt(y+1).ajouterPersonnage(this);
						if(monTerrain.getGrille().elementAt(x).elementAt(y+1).getPersonnage() != null) {
							if(!monTerrain.getGrille().elementAt(x).elementAt(y+1).getPersonnage().getClass().getSimpleName().equalsIgnoreCase("Humain") && !monTerrain.getGrille().elementAt(x).elementAt(y+1).getPersonnage().getClass().getSimpleName().equalsIgnoreCase("Nain") ) {
								this.vaAttaquer = true;
							}
						}
						
					}
						break;
				}
			}else if(this.y == 14) {
				//	ne peut pas d�placer en bas et droite
				switch(monDe.lanceZero(2)) {
				case 0 :
					if(monTerrain.getGrille().elementAt(x-1).elementAt(y).isEstVide()) {
						monTerrain.getGrille().elementAt(x-1).elementAt(y).ajouterPersonnage(this);
					}else {
						// combat
//						monTerrain.getGrille().elementAt(x-1).elementAt(y).ajouterPersonnage(this);
						if(monTerrain.getGrille().elementAt(x-1).elementAt(y).getPersonnage() != null) {
							if(!monTerrain.getGrille().elementAt(x-1).elementAt(y).getPersonnage().getClass().getSimpleName().equalsIgnoreCase("Humain") && !monTerrain.getGrille().elementAt(x-1).elementAt(y).getPersonnage().getClass().getSimpleName().equalsIgnoreCase("Nain") ) {
								this.vaAttaquer = true;
							}
						}
					}
						break;
				case 1 :
					if(monTerrain.getGrille().elementAt(x).elementAt(y-1).isEstVide()) {
						monTerrain.getGrille().elementAt(x).elementAt(y-1).ajouterPersonnage(this);
					}else {
						// combat
//						monTerrain.getGrille().elementAt(x).elementAt(y-1).ajouterPersonnage(this);
						if(monTerrain.getGrille().elementAt(x).elementAt(y-1).getPersonnage() != null) {
							if(!monTerrain.getGrille().elementAt(x).elementAt(y-1).getPersonnage().getClass().getSimpleName().equalsIgnoreCase("Humain") && !monTerrain.getGrille().elementAt(x).elementAt(y-1).getPersonnage().getClass().getSimpleName().equalsIgnoreCase("Nain") ) {
								this.vaAttaquer = true;
							}
						}
					}
						break;
				}
			}
		}
		
		
	}
		
}

