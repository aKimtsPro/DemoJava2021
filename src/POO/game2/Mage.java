package POO.game2;
import java.util.Scanner;

public class Mage extends Entite implements CanAttack{

	
	public Mage(Scanner scan) {
		System.out.println("Nouveau Mage >>");
		System.out.println("Nom : ");
		name = scan.nextLine();
		System.out.println("Points de vie : ");
		healthPoint = Integer.parseInt(scan.nextLine());
		System.out.println("Points de mana : ");
		manaPoint = Integer.parseInt(scan.nextLine());
	}
	
	public Mage(String name, int healthPoint, int manaPoint) {
		this.name = name;
		this.healthPoint = healthPoint;
		this.manaPoint = manaPoint;
		this.totalHealthPoint = healthPoint;
	}
	
	public int attack(Entite target, Entite striker) {
		
		int pointPerdu = striker.forcePoint + striker.manaPoint;
		attackTotalPoint+=pointPerdu;
		int pointDeVieRestant = target.healthPoint - pointPerdu;
		
		//		Eviter les PV n�gatifs
			if(pointDeVieRestant < 0) {
				pointDeVieRestant = 0;
			}
		System.out.printf("%20s attaque et enl�ve %5d pts � %20s [PV restant : %5d]\n",striker.name,pointPerdu,target.name,pointDeVieRestant);
	
		return pointDeVieRestant;
	}
	

}
