package POO.game.classes;

import POO.game.interfaces.IDepecable;

public class Loup extends Monstre implements IDepecable{

	
	
	public Loup(String nom) {
		// TODO Auto-generated constructor stub
		monDe = new De();
		this.nom = nom;
		this.force = calculerStatDemarrage(creerValeurs());
		this.endurance = calculerStatDemarrage(creerValeurs());
		this.pointsVie = this.getEndurance() + calculerModificateur(this.getEndurance() + this.enduBonus);
		this.pointsVieTotal = this.pointsVie;
		this.cuir = this.monDe.lance(5);
		this.cuirCumule = this.cuir;
		this.estMort = false;
		this.afficherInfo();
	}

	@Override
	public void depecer(Heros heros) {
		// Envoi des ressources vers le heros
		heros.cuirStocke = this.cuir;
		
	}
	
	protected void afficherInfo() {
		if(this.getPointsVie()<0) {
			this.pointsVie = 0;
		}
		System.out.printf("%13s | PV [%2d/%2d] | FORCE : %2d | ENDU : %2d >> CUIR : %3d pc\n",this.getClass().getSimpleName(), this.getPointsVie(), this.getPointsVieTotal(), this.getForce(), this.getEndurance(), this.cuirCumule);

	}

}
