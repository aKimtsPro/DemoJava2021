package POO.game.classes;

public abstract class Monstre extends Personnage {

	protected int or;
	protected int orCumule;
	protected int cuir;
	protected int cuirCumule;
	protected int forceBonus;
	protected int enduBonus;
		
	public Monstre() {
		// TODO Auto-generated constructor stub
	}
	
	protected void afficherInfo() {
		
		System.out.printf("%13s | PV [%2d/%2d] | FORCE : %2d | ENDU : %2d\n",this.getClass().getSimpleName(), this.getPointsVie(), this.getPointsVieTotal(), this.getForce(), this.getEndurance());
	}
	
	protected void cumulerRecompenses()	{
		this.orCumule += this.monDe.lance(7);
		this.cuirCumule += this.monDe.lance(5);
	}
}
