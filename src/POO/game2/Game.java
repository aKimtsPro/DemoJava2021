package POO.game2;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Game {

	public Warrior guerrier;
	public Thief voleur;
	public Mage mago;
	public Priest pretre;
	public Enemy mob;
	public Vector<Entite> groupe, groupeMort;
	public int compteur;
	
	
	public Game() {
		// TODO Auto-generated constructor stub
		Scanner scan = new Scanner(System.in);
		guerrier = new Warrior("Conan",3000,35);
		voleur = new Thief("Fufu",1700,25,12);
		mago = new Mage("Ikaron",1500,40);
		pretre = new Priest("Doctor", 1050, 40);
		mob = new Enemy("The BIG BIG BOSS", 10000, 120, 50);
		
		groupe = new Vector<Entite>();
		groupe.add(guerrier);
		groupe.add(voleur);
		groupe.add(mago);
		groupe.add(pretre);
		
		groupeMort = new Vector<Entite>();
		
		compteur = 0;
		
		demarrerCombat();
	}
	
	public void demarrerCombat() {
		
		//	Chaque tour
		do {
			Random alea = new Random();
			Random mobAlea = new Random();
			int temp = groupe.size()+1;
			int aleatoireTemp = alea.nextInt(temp);
			
			//	Choix de l'entit� qui va avoir le droit de faire une action
			if(aleatoireTemp <= groupe.size()-1){
				if(groupe.elementAt(aleatoireTemp).healthPoint>=0) {
					switch(groupe.elementAt(aleatoireTemp).getClass().getSimpleName()) {
						case ("Warrior") :
							mob.healthPoint = guerrier.attack(mob, guerrier);
							break;
						case ("Thief") :
							mob.healthPoint = voleur.attack(mob, voleur);
							break;
						case ("Mage") :
							mob.healthPoint = mago.attack(mob, mago);
							break;
						case ("Priest") :
							//	Choix de l'entit� � soigner
							for(int j=0;j<groupe.size();j++) {
								if(mobAlea.nextInt(groupe.size()) == j ) {
									switch (groupe.elementAt(j).getClass().getSimpleName()) {
									case ("Warrior"):
										guerrier.healthPoint = pretre.heal(guerrier, pretre);
										break;
									case ("Thief"):
										voleur.healthPoint = pretre.heal(voleur, pretre);
										break;
									case ("Mage"):
										mago.healthPoint = pretre.heal(mago, pretre);
										break;
									case ("Priest"):
										pretre.healthPoint = pretre.heal(pretre, pretre);
										break;
									default:
										break;
									}
								}
							}
							break;
							
						default :
							break;
						}
				}
			}else {
				//	Si ok >> Mob se soigne sinon Mob attaque
				if(mobAlea.nextInt(groupe.size()+2) == groupe.size()+1) {
					mob.healthPoint = mob.heal(mob, mob);
				}else {	
					//	Choix de l'entit� � attaquer
					for(int j=0;j<groupe.size();j++) {
							if(mobAlea.nextInt(groupe.size()) == j ) {
								switch (groupe.elementAt(j).getClass().getSimpleName()) {
								case ("Warrior"):
									guerrier.healthPoint = mob.attack(guerrier, mob);
									if(guerrier.healthPoint <= 0) {
										guerrier.afficherMortEntite();
										groupeMort.add(guerrier);
										groupe.remove(guerrier);
										}
									break;
								case ("Thief"):
									voleur.healthPoint = mob.attack(voleur, mob);
									if(voleur.healthPoint <= 0) {
										voleur.afficherMortEntite();
										groupeMort.add(voleur);
										groupe.remove(voleur);
									}
									break;
								case ("Mage"):
									mago.healthPoint = mob.attack(mago, mob);
									if(mago.healthPoint <= 0) {
										mago.afficherMortEntite();
										groupeMort.add(mago);
										groupe.remove(mago);
										}
									break;
								case ("Priest"):
									pretre.healthPoint = mob.attack(pretre, mob);
									if(pretre.healthPoint <= 0) {
										pretre.afficherMortEntite();
										groupeMort.add(pretre);
										groupe.remove(pretre);
										}
									break;
								default:
									break;
								}
							}
						}
					}
				}
			compteur++;
		
			
		}while(mob.healthPoint > 0 && !groupe.isEmpty());
		
		afficherResultats();		
	}
	
	public void afficherResultats() {
		if(groupe.isEmpty()) {
			System.out.println("\n\t\tL'�quipe s'est fait terrass�e par "+mob.name+" en "+compteur+" tours\n");
			mob.afficherStatsEntite();
			afficherMortsGroupe(groupeMort);
		}else {
			System.out.println("\n\tVictoire !!! L'�quipe ( "+groupe.size()+") a fait mordre la poussi�re � "+mob.name+" en "+compteur+" tours\n");
			for(Entite c : groupe) {
				c.afficherStatsEntite();
			}
			afficherMortsGroupe(groupeMort);
		}
		System.out.printf("\n%60s","* Fin du jeu *");
		
	}
	
	public void afficherMortsGroupe(Vector<Entite> elem) {
		System.out.println("\n\t\t"+elem.size()+" Mort(s) au combat ...\n");
		for(Entite e : elem) {
			e.afficherStatsEntite();
		}
	}
	
}
