package POO.game.classes;

public class Case {

	private int x,y;
	private Personnage personnage;
	private boolean estVide;
	
	public Case() {
		// TODO Auto-generated constructor stub
	}
	
	public Case(int x, int y, Personnage personnage) {
		this.x = x;
		this.y = y;
		this.personnage = personnage;
		this.estVide = true;
	}
	
	public void ajouterPersonnage(Personnage personnage) {
		this.personnage = personnage;
		if(personnage == null) {
			this.estVide = true;
		}else {
			this.estVide = false;
		}
		
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setEstVide(boolean estVide) {
		this.estVide = estVide;
	}

	public boolean isEstVide() {
		return estVide;
	}

	public Personnage getPersonnage() {
		return personnage;
	}

}
