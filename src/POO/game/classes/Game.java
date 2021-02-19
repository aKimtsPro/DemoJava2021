package POO.game.classes;

import java.util.Scanner;
import java.util.Vector;

public class Game {

	private Terrain monTerrain;
	private Vector<Heros> herosListe;
	private Vector<Monstre> monstreListe;
	private De monDe;
	private Heros monHeros,el;
	private Monstre loup, loup1, loup2, dragon, dragon1, dragon2, orc, orc1, orc2;
	private Scanner scan;
	
	public Game() {
		
		lancerGameTexte();
	//	lancerGameGraphique();
	}
	
	private void lancerGameTexte() {
		
		System.out.printf("%69s\n\n", "CREATION DES PERSONNAGES");
		
		monDe = new De();
		monHeros = new Humain("Humain");
		el = new Nain("Nain");
		loup = new Loup("Loup");
		dragon = new Dragonnet("Dragonnet");
		orc = new Orque("Orc");
		scan = new Scanner(System.in);
		herosListe = new Vector<Heros>();
		monstreListe = new Vector<Monstre>();
		
		herosListe.add(monHeros);
		herosListe.add(el);
		monstreListe.add(loup);
		monstreListe.add(dragon);
		monstreListe.add(orc);
		//System.out.printf("%13d h�ros || %2d monstres",herosListe.size(),monstreListe.size());
		scan.nextLine();
		System.out.println();
						
		System.out.printf("%65s\n\n", "DEBUT DU COMBAT");
		
		do {
			//nouveauCombat(herosListe.get(monDe.lanceZero(herosListe.size())), monstreListe.get(monDe.lanceZero(monstreListe.size())));
			nouveauCombatEquipe(herosListe, monstreListe.get(monDe.lanceZero(monstreListe.size())));
			scan.nextLine();
			
		}while(!herosListe.isEmpty() && !monstreListe.isEmpty());
		
		afficherFinCombat();
		scan.close();
					
	}
	
	private void lancerGameGraphique() {
		System.out.printf("%69s\n\n", "CREATION DES PERSONNAGES");
		
		monDe = new De();
		scan = new Scanner(System.in);
		monHeros = new Humain("Link");
		el = new Nain("Gilmy");
		loup = new Loup("M�re Louve");
		loup1 = new Loup("Jeune Loup");
		loup2 = new Loup("Loup Adulte");
		dragon= new Dragonnet("Dragon de feu");
		dragon1 = new Dragonnet("Dragon de glace");
		dragon2 = new Dragonnet("Dragon du N�ant");
		orc = new Orque("Thrall");
		orc1 = new Orque("Balrog");
		orc2 = new Orque("Ramal");
		herosListe = new Vector<Heros>();
		monstreListe = new Vector<Monstre>();
		
		herosListe.add(monHeros);
	//	herosListe.add(el);
		monstreListe.add(loup);
		monstreListe.add(loup1);
		monstreListe.add(loup2);
		monstreListe.add(dragon);
		monstreListe.add(dragon1);
		monstreListe.add(dragon2);
		monstreListe.add(orc);
		monstreListe.add(orc1);
		monstreListe.add(orc2);
		
		//System.out.printf("%13d h�ros || %2d monstres",herosListe.size(),monstreListe.size());
		System.out.println();
		
		monTerrain = new Terrain(herosListe, monstreListe, monDe);
		
		scan.nextLine();
		
		demarrerJeuGraphique();
		
		scan.close();
	}

	private void demarrerJeuGraphique() {
		while(!herosListe.isEmpty() && !monstreListe.isEmpty()) {
			
			for(Heros h : herosListe) {
				h.seDeplace(monTerrain);
				scan.nextLine();
				if(h.vaAttaquer) {
					System.out.println("Heros va attaquer !!!");
				//	nouveauCombat(h, dragon);
					int temp = monDe.lanceZero(monstreListe.size());
					nouveauCombat(h, monstreListe.get(temp));
					for(Monstre m : monstreListe) {
						if(m.x == h.x && m.y == h.y) {
							nouveauCombat(h, m);
						}
						
						
					}
					if(!h.estMort) {
						h.vaAttaquer = false;
					}
				}
				monTerrain.afficherGrille();
				
				
			}
			
			
			
		}
		
		afficherFinCombat();
	}

	private void afficherFinCombat() {
		// TODO Auto-generated method stub
		System.out.printf("\n%50s | %15s\n\n", "FIN DU JEU", "STATISTIQUES FINALES");
		
		if(!herosListe.isEmpty()) {
			for(Heros h : herosListe) {
				h.afficherInfo();
			}
		}else {
			for(Monstre m : monstreListe) {
				m.afficherInfo();
			}
		}
	}
		
	private void nouveauCombatEquipeMultiple(Vector<Heros> listeHeros, Vector<Monstre> listeMonstre) {
		int temp = 0;
		
		for(Monstre m : listeMonstre) {
			m.cumulerRecompenses();
		}
		do{
			if(monDe.lance(21) % 2 == 0) {
				for(Monstre m : listeMonstre) {
					m.cumulerRecompenses();
				}
				listeHeros.elementAt(monDe.lanceZero(listeHeros.size())).frappe(listeMonstre.elementAt(monDe.lanceZero(listeMonstre.size())));
				
			}else {
				for(Monstre m : listeMonstre) {
					m.cumulerRecompenses();
				}
				temp = monDe.lanceZero(listeHeros.size());
				listeMonstre.elementAt(monDe.lanceZero(listeMonstre.size())).frappe(listeHeros.elementAt(temp));
				if(listeHeros.elementAt(temp).estMort) {
					herosListe.remove(listeHeros.elementAt(temp));
				}
			}
			
			for(Monstre m : listeMonstre) {
				m.cumulerRecompenses();
			}
						
		}while(!listeMonstre.isEmpty() && !listeHeros.isEmpty());
		
		for(Monstre m : listeMonstre) {
			if(m.estMort) {
				monstreListe.remove(m);
				listeHeros.elementAt(monDe.lanceZero(listeHeros.size())).recolterRecompenses(m);
				if(!monstreListe.isEmpty()) {
					for(Heros h : herosListe) {
						h.seReposer();
					}
				}
			}
		}
	}

	private void nouveauCombatEquipe(Vector<Heros> listeHeros, Monstre monstre) {
		int temp = 0;
		monstre.cumulerRecompenses();
		do{
			
			if(monDe.lance(21) % 2 == 0) {
				monstre.cumulerRecompenses();
				listeHeros.elementAt(monDe.lanceZero(listeHeros.size())).frappe(monstre);
				
			}else {
				monstre.cumulerRecompenses();
				temp = monDe.lanceZero(listeHeros.size());
				monstre.frappe(listeHeros.elementAt(temp));
				if(listeHeros.elementAt(temp).estMort) {
					herosListe.remove(listeHeros.elementAt(temp));
				}
				
			}
			monstre.cumulerRecompenses();
			
		}while(!monstre.estMort && !listeHeros.isEmpty());
		
		if(monstre.estMort) {
			monstreListe.remove(monstre);
			listeHeros.elementAt(monDe.lanceZero(listeHeros.size())).recolterRecompenses(monstre);
			if(!monstreListe.isEmpty()) {
				for(Heros h : herosListe) {
					h.seReposer();
				}
			}
		}
	}
	
	private void nouveauCombat(Heros heros, Monstre monstre) {
	
		do {
			if(monDe.lance(21) % 2 == 0) {
				heros.frappe(monstre);
			}else {
				monstre.frappe(heros);
			}
			monstre.cumulerRecompenses();
				
			
		}while(!heros.estMort && !monstre.estMort);
		
		if(heros.estMort) {
			herosListe.remove(heros);
		//	System.out.printf("%13s est retir� de la liste | taille : %d\n",heros.getClass().getSimpleName(), herosListe.size());
		}else {
			monstreListe.remove(monstre);
			heros.recolterRecompenses(monstre);
			heros.vaAttaquer = false;
			if(!monstreListe.isEmpty()) {
				for(Heros h : herosListe) {
					h.seReposer();
				}
			}
		//	System.out.printf("%13s est retir� de la liste | taille : %d\n",monstre.getClass().getSimpleName(), monstreListe.size());

		}
		
		
		
	}
		
	public De getMonDe() {
		return monDe;
	}

	public void setMonDe(De monDe) {
		this.monDe = monDe;
	}

}
