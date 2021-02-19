package POO.game2;

public abstract class Entite {
	
	public String name;
	public int totalHealthPoint; 	//	PV total
	public int healthPoint;			//  PV en cours
	public int forcePoint;			//	Force
	public int manaPoint;			//	Mana total
	public int attackTotalPoint;	//	D�gats totaux
	public int healingTotalPoint;   //	Soins Totaux		
		
	public void afficherMortEntite() {
		System.out.println("______________________________________________________________________________________________________");
		System.out.println("\n\t\t\t\t\t"+this.name+" est mort !!!!!!!!!");
		System.out.println("______________________________________________________________________________________________________\n");
		
	}
	
	public void afficherStatsEntite() {
		if(healthPoint < 0) {
			this.healthPoint = 0;
		}
		System.out.printf("%10s >> [ PV : %5d / %5d ] >> D�gats effectu�s : %5d >> Soins re�us : %5d\n",this.name, this.healthPoint, this.totalHealthPoint, this.attackTotalPoint, this.healingTotalPoint);

	}
}
