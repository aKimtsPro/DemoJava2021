package POO.exo.heritage.musique;

public abstract class Musique {
    private String nom;
    private int longueur;

    public Musique(String nom, int longueur) {
        this.nom = nom;
        this.longueur = longueur;
    }
    public abstract void jouer();

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getLongueur() {
        return longueur;
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }
}
