package POO.game.classes;

public abstract class Heros extends Personnage{
	
	protected int enduBonus;
	protected int forceBonus;
	protected int cuirStocke;
	protected int orStocke;
	
	protected void seReposer() {
		this.pointsVie = this.pointsVieTotal;
		System.out.printf("%13s se repose et remonte ses PV [%2d/%2d]\n",this.getClass().getSimpleName(),this.getPointsVie(), this.getPointsVieTotal());
	}
	
	protected void afficherInfo() {
		System.out.printf("%13s | PV [%2d/%2d] | FORCE : %2d | ENDU : %2d >> BONUS : +%d FORCE - +%d ENDU >> GAINS : %3d po | %3d pc\n",this.getClass().getSimpleName(), this.getPointsVie(), this.getPointsVieTotal(), this.getForce(), this.getEndurance(), this.forceBonus, this.enduBonus, this.orStocke, this.cuirStocke);
	}
	
	protected void recolterRecompenses(Monstre monstre) {
		this.orStocke += monstre.orCumule;
		this.cuirStocke += monstre.cuirCumule;
		if(monstre.cuir == 0) {
			System.out.printf("%13s gagne %3d po\n", this.getClass().getSimpleName(), monstre.orCumule - monstre.or);
		}else if(monstre.or == 0) {
			System.out.printf("%13s gagne %3d pc\n", this.getClass().getSimpleName(), monstre.cuirCumule - monstre.cuir);
		}else {
			System.out.printf("%13s gagne %3d po et %3d pc\n", this.getClass().getSimpleName(), monstre.orCumule - monstre.or, monstre.cuirCumule - monstre.cuir);
		}
		
	}
}
