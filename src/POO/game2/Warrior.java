package POO.game2;
import java.util.Scanner;

public class Warrior extends Entite implements CanAttack{

	public Warrior(Scanner scan) {
		System.out.println("Nouveau Guerrier >>");
		System.out.println("Nom : ");
		name = scan.nextLine();
		System.out.println("Points de vie : ");
		healthPoint = Integer.parseInt(scan.nextLine());
		System.out.println("Points de force : ");
		forcePoint = Integer.parseInt(scan.nextLine());
	}
	public Warrior(String name, int healthPoint, int forcePoint) {
		this.name = name;
		this.healthPoint = healthPoint;
		this.totalHealthPoint = healthPoint;
		this.forcePoint = forcePoint;
	}
	
	public int attack(Entite target, Entite striker) {
		
		int pointPerdu = striker.forcePoint + striker.manaPoint;
		attackTotalPoint+=pointPerdu;
		int pointDeVieRestant = target.healthPoint - pointPerdu;
		
		//	Eviter les PV n�gatifs
		if(pointDeVieRestant < 0) {
			pointDeVieRestant = 0;
		}
		System.out.printf("%20s attaque et enl�ve %5d pts � %20s [PV restant : %5d]\n",striker.name,pointPerdu,target.name,pointDeVieRestant);
	
		return pointDeVieRestant;
	}
	
	

}
