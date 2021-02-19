package POO.game2;

import java.util.Scanner;

public class Enemy extends Entite implements CanAttack, CanHealing {

	public Enemy(Scanner scan) {
		System.out.println("Nouveau Ennemi >>");
		System.out.println("Nom : ");
		name = scan.nextLine();
		System.out.println("Points de vie : ");
		healthPoint = Integer.parseInt(scan.nextLine());
		System.out.println("Points de force : ");
		forcePoint = Integer.parseInt(scan.nextLine());
		System.out.println("Points de mana : ");
		manaPoint = Integer.parseInt(scan.nextLine());
	}
	public Enemy(String name, int healthPoint, int forcePoint, int manaPoint) {
		this.name = name;
		this.healthPoint = healthPoint;
		this.forcePoint = forcePoint;
		this.totalHealthPoint = healthPoint;
		this.manaPoint = manaPoint;
	}
	
	public int attack(Entite target, Entite striker) {
		int pointPerdu = striker.forcePoint;
		attackTotalPoint+=pointPerdu;
		int pointDeVieRestant = target.healthPoint - pointPerdu;
		
		//		Eviter les PV n�gatifs
			if(pointDeVieRestant < 0) {
				pointDeVieRestant = 0;
			}
		System.out.printf("%20s attaque et enl�ve %5d pts � %20s [PV restant : %5d]\n",striker.name,pointPerdu,target.name,pointDeVieRestant);
	
		return pointDeVieRestant;
	}
	@Override
	public int heal(Entite target, Entite healer) {
		int pointDeVieRestant = target.healthPoint;
		if(target.healthPoint + healer.manaPoint <= target.totalHealthPoint) {
		//	healingTotalPoint+=healer.manaPoint;
			target.healingTotalPoint+=healer.manaPoint;
			pointDeVieRestant = target.healthPoint + healer.manaPoint;
			System.out.printf("%20s soigne et redonne %5d pts � %20s [PV restant : %5d]\n",healer.name,healer.manaPoint,target.name,pointDeVieRestant);
		
		}
		return pointDeVieRestant;
		
	}
	

}
