package POO.game2;
import java.util.Scanner;

public class Priest extends Entite implements CanHealing{

	public Priest(Scanner scan) {
		System.out.println("Nouveau Pr�tre >>");
		System.out.println("Nom : ");
		name = scan.nextLine();
		System.out.println("Points de vie : ");
		healthPoint = Integer.parseInt(scan.nextLine());
		System.out.println("Points de mana : ");
		manaPoint = Integer.parseInt(scan.nextLine());
	}
	public Priest(String name, int healthPoint, int manaPoint) {
		this.name = name;
		this.healthPoint = healthPoint;
		this.manaPoint = manaPoint;
		this.totalHealthPoint = healthPoint;
	}

	@Override

	public int heal(Entite target, Entite healer) {
		// TODO Auto-generated method stub
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
