package POO.game.classes;

import POO.game.interfaces.IDepecable;

public class Dragonnet extends Monstre implements IDepecable{
	
	
		
	public Dragonnet(String nom) {
		// TODO Auto-generated constructor stub
		monDe = new De();
		this.nom = nom;
		this.force = calculerStatDemarrage(creerValeurs());
		this.endurance = calculerStatDemarrage(creerValeurs());
		this.enduBonus = 1;
		this.pointsVie = this.getEndurance() + calculerModificateur(this.getEndurance() + this.enduBonus);
		this.pointsVieTotal = this.pointsVie;
		this.or = this.monDe.lance(7);
		this.cuir = this.monDe.lance(5);
		this.cuirCumule = this.cuir;
		this.orCumule = this.or;
		this.estMort = false;
		this.afficherInfo();
	}

	@Override
	public void depecer(Heros heros) {
		// TODO Auto-generated method stub
		heros.cuirStocke = this.cuir;
		
	}
	protected void afficherInfo() {
		if(this.getPointsVie()<0) {
			this.pointsVie = 0;
		}
		System.out.printf("%13s | PV [%2d/%2d] | FORCE : %2d | ENDU : %2d >> BONUS : +%2d ENDU  | OR : %3d po | CUIR : %3d pc\n",this.getClass().getSimpleName(), this.getPointsVie(), this.getPointsVieTotal(), this.getForce(), this.getEndurance(), this.enduBonus, this.orCumule, this.cuirCumule);

	}
	
	
	

}
