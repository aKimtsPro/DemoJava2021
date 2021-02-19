package POO.game.classes;

public class Nain extends Heros{

	public Nain(String nom) {
		// TODO Auto-generated constructor stub
		monDe = new De();
		this.nom = nom;
		this.force = calculerStatDemarrage(creerValeurs());
		this.endurance = calculerStatDemarrage(creerValeurs());
		this.pointsVie = this.getEndurance() + calculerModificateur(this.getEndurance() + this.enduBonus);
		this.pointsVieTotal = this.pointsVie;
		this.forceBonus = 2;
		this.estMort = false;
		this.vaAttaquer = false;
		this.afficherInfo();
	}

	protected void afficherInfo() {
		if(this.getPointsVie()<0) {
			this.pointsVie = 0;
		}
		System.out.printf("%13s | PV [%2d/%2d] | FORCE : %2d | ENDU : %2d >> BONUS : +%2d FORCE            >> GAINS : %3d po | %3d pc\n",this.getClass().getSimpleName(), this.getPointsVie(), this.getPointsVieTotal(), this.getForce(), this.getEndurance(), this.forceBonus, this.orStocke, this.cuirStocke);
		
	}
}
