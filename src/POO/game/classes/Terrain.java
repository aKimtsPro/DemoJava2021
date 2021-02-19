package POO.game.classes;

import java.util.Vector;

public class Terrain {

	private Vector<Vector<Case>> grille;
	private De monDe;
	private Vector<Heros> herosListe;
	private Vector<Monstre> monstreListe;
	private final int TAILLEGRILLE = 15;
	
 	public Terrain() {
		// TODO Auto-generated constructor stub
 		
	}
	
	public Terrain(Vector<Heros> herosListe, Vector<Monstre> monstreListe, De de) {
		this.herosListe = herosListe;
		this.monstreListe = monstreListe;
		this.monDe = de;
		creerGrille();
	}
	
	private void creerGrille() {
		grille = new Vector<Vector<Case>>();
		for(int i = 0; i < TAILLEGRILLE; i++) {
			grille.add(new Vector<Case>());
			for(int j = 0 ; j < TAILLEGRILLE; j++) {
				grille.elementAt(i).add(new Case(i,j, null));
			}
		}
		placerPersonnagesAlea();
		afficherGrille();
	}

	private void placerPersonnagesAlea() {
		
		int x=0, y=0;
		int nbPersonnages = this.monstreListe.size();
		//Placement des h�ros x0 y6
		int xHeros = 0, yHeros = 6;
		for(Heros h : herosListe) {
			grille.elementAt(xHeros).elementAt(yHeros).ajouterPersonnage(h);
			yHeros++;
			System.out.println(grille.elementAt(xHeros).elementAt(yHeros).getX());
			System.out.println(grille.elementAt(xHeros).elementAt(yHeros).getY());
		}
		
		// Placement des monstres
		do {
			x = monDe.lanceZero(TAILLEGRILLE);
			y = monDe.lanceZero(TAILLEGRILLE);
			
			Case c = grille.elementAt(x).elementAt(y);
			
			Case cGauche = grille.elementAt(x).elementAt(y);
			Case cGaucheLimite  = grille.elementAt(x).elementAt(y);
			Case cDroite = grille.elementAt(x).elementAt(y);
			Case cDroiteLimite = grille.elementAt(x).elementAt(y);
			Case cHaut = grille.elementAt(x).elementAt(y);
			Case cHautLimite = grille.elementAt(x).elementAt(y);
			Case cBas = grille.elementAt(x).elementAt(y);
			Case cBasLimite = grille.elementAt(x).elementAt(y);
			if (x >= 2  && x <=12) {
				if(y >= 2 && y <=12) {
					cGauche = grille.elementAt(x-1).elementAt(y);
					cGaucheLimite = grille.elementAt(x-2).elementAt(y);
					cDroite = grille.elementAt(x+1).elementAt(y);
					cDroiteLimite = grille.elementAt(x+2).elementAt(y);
					cHaut = grille.elementAt(x).elementAt(y-1);
					cHautLimite = grille.elementAt(x).elementAt(y-2);
					cBas = grille.elementAt(x).elementAt(y+1);
					cBasLimite = grille.elementAt(x).elementAt(y+2);
					
				}else if(y==1) {
					cGauche = grille.elementAt(x-1).elementAt(y);
					cGaucheLimite = grille.elementAt(x-2).elementAt(y);
					cDroite = grille.elementAt(x+1).elementAt(y);
					cDroiteLimite = grille.elementAt(x+2).elementAt(y);
					cHaut = grille.elementAt(x).elementAt(y-1);
					cBas = grille.elementAt(x).elementAt(y+1);
					cBasLimite = grille.elementAt(x).elementAt(y+2);
				}else if(y==0) {
					cGauche = grille.elementAt(x-1).elementAt(y);
					cGaucheLimite = grille.elementAt(x-2).elementAt(y);
					cDroite = grille.elementAt(x+1).elementAt(y);
					cDroiteLimite = grille.elementAt(x+2).elementAt(y);
					cBas = grille.elementAt(x).elementAt(y+1);
					cBasLimite = grille.elementAt(x).elementAt(y+2);
				}else if(y==13) {
					cGauche = grille.elementAt(x-1).elementAt(y);
					cGaucheLimite = grille.elementAt(x-2).elementAt(y);
					cDroite = grille.elementAt(x+1).elementAt(y);
					cDroiteLimite = grille.elementAt(x+2).elementAt(y);
					cHaut = grille.elementAt(x).elementAt(y-1);
					cHautLimite = grille.elementAt(x).elementAt(y-2);
					cBas = grille.elementAt(x).elementAt(y+1);
				}else if(y==14) {
					cGauche = grille.elementAt(x-1).elementAt(y);
					cGaucheLimite = grille.elementAt(x-2).elementAt(y);
					cDroite = grille.elementAt(x+1).elementAt(y);
					cDroiteLimite = grille.elementAt(x+2).elementAt(y);
					cHaut = grille.elementAt(x).elementAt(y-1);
					cHautLimite = grille.elementAt(x).elementAt(y-2);
					}
			}else if(x==1 && (y >=2 && y<=12)) {
					cGauche = grille.elementAt(x-1).elementAt(y);
					cDroite = grille.elementAt(x+1).elementAt(y);
					cDroiteLimite = grille.elementAt(x+2).elementAt(y);
					cHaut = grille.elementAt(x).elementAt(y-1);
					cHautLimite = grille.elementAt(x).elementAt(y-2);
					cBas = grille.elementAt(x).elementAt(y+1);
					cBasLimite = grille.elementAt(x).elementAt(y+2);
					
			}else if(x==0 && (y >=2 && y<=12)) {
					cDroite = grille.elementAt(x+1).elementAt(y);
					cDroiteLimite = grille.elementAt(x+2).elementAt(y);
					cHaut = grille.elementAt(x).elementAt(y-1);
					cHautLimite = grille.elementAt(x).elementAt(y-2);
					cBas = grille.elementAt(x).elementAt(y+1);
					cBasLimite = grille.elementAt(x).elementAt(y+2);
			}else if(x==13 && (y >=2 && y<=12)) {
				cGauche = grille.elementAt(x-1).elementAt(y);
				cGaucheLimite = grille.elementAt(x-2).elementAt(y);
				cDroite = grille.elementAt(x+1).elementAt(y);
				cHaut = grille.elementAt(x).elementAt(y-1);
				cHautLimite = grille.elementAt(x).elementAt(y-2);
				cBas = grille.elementAt(x).elementAt(y+1);
				cBasLimite = grille.elementAt(x).elementAt(y+2);
			}else if(x==14 && (y >=2 && y<=12)) {
				cGauche = grille.elementAt(x-1).elementAt(y);
				cGaucheLimite = grille.elementAt(x-2).elementAt(y);
				cHaut = grille.elementAt(x).elementAt(y-1);
				cHautLimite = grille.elementAt(x).elementAt(y-2);
				cBas = grille.elementAt(x).elementAt(y+1);
				cBasLimite = grille.elementAt(x).elementAt(y+2);
			}
			
			if(c.isEstVide() && cGauche.isEstVide() && cGaucheLimite.isEstVide() && cDroite.isEstVide() && cDroiteLimite.isEstVide() && cHaut.isEstVide() && cHautLimite.isEstVide() && cBas.isEstVide() && cBasLimite.isEstVide()) {
				if (x >= 2  && x <=12) {
					if(y >= 2 && y <=12) {
//						grille.elementAt(x-1).elementAt(y).setEstVide(false);
//						grille.elementAt(x-2).elementAt(y).setEstVide(false);
//						grille.elementAt(x+1).elementAt(y).setEstVide(false);
//						grille.elementAt(x+2).elementAt(y).setEstVide(false);
//						grille.elementAt(x).elementAt(y-1).setEstVide(false);
//						grille.elementAt(x).elementAt(y-2).setEstVide(false);
//						grille.elementAt(x).elementAt(y+1).setEstVide(false);
//						grille.elementAt(x).elementAt(y+2).setEstVide(false);
					}
				}
				int temp = monDe.lanceZero(monstreListe.size());
				c.ajouterPersonnage(monstreListe.get(temp));
//				monstreListe.get(temp).x = x;
//				monstreListe.get(temp).y = y;
			//	this.monstreListe.remove(temp);
												
				
				nbPersonnages--;
			}
			
		}while(nbPersonnages>0);
		
	}
	
	public void afficherGrille() {
		
		afficherDecor();
		for(int i=0;i<TAILLEGRILLE;i++) {
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
			for(int j=0;j<TAILLEGRILLE;j++) {
				
				if(grille.get(i).get(j).getPersonnage()==null) {
					System.out.print("        |");
				}else {
				
					System.out.printf("%5s   |",grille.get(i).get(j).getPersonnage().afficherPersonnage());
				}				
				if(j==TAILLEGRILLE-1) {
					System.out.println();
				}
			}
		}
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");

	}
	
	public Vector<Vector<Case>> getGrille() {
		return grille;
	}

	public void setGrille(Vector<Vector<Case>> grille) {
		this.grille = grille;
	}

	private void afficherDecor() {
		System.out.printf("\n");
		System.out.print("		        |ZZzz                 ;;                           ::\n");
		System.out.print("		 |Zzz   |      |Zzz       ; :: o :: ;                   :: `:;;`::\n");
		System.out.print("	        /_\\  /\\ | /\\ /_\\         o::\\ :| ::o/::               ` ::;;\\`::\\\n");
		System.out.print("	        |*|__||/_\\||_|*|      :::o::o;::o:;                 :::\\ ::::'`\n");
		System.out.print("		|......|*|....|      __  o :\\:::/:: ;                  :`::\\://::\n");
		System.out.print("		_~| .. !~! .. |~___ (~ \\____ | |__ ; ____________      _____| |_______________________________\n");
		System.out.print("		*.|____|_|____|.*. ('    )   | |   o            )~~~~(      |^|\n");
		System.out.print("		                  ~~~~~     /' `\\             ~) ~  ~(     / ^ \\\n");
		System.out.print("      		                                          )~  o<  ~~(\n");
		System.out.print("              		                               )~~  ~   ~   ~~~(\n");
		System.out.print("                       		                      )~~    0< ~   0<   ~~(\n");

	}

}
