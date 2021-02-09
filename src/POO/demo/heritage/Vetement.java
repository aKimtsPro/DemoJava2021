package POO.demo.heritage;

public class Vetement extends Article {

    private String taille;

    public Vetement(String marque, String nom, double prix, int reduction, String taille) {
        super(marque, nom, prix, reduction);
        this.taille = taille;
    }

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    @Override
    public void presenter() {

    }
}
