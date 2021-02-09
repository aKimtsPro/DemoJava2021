package POO.exo.encaps;

public class Article {

    private String marque = "inconnue";
    private String nom = "inconnu";
    private double prix;
    private int reduction;

    public Article(String marque, String nom, double prix) {
        this.setMarque(marque);
        this.setNom(nom);
        this.setPrix(prix);
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        if(marque != null && marque.length() >= 5 && marque.length() <= 20)
            this.marque = marque;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        if(nom != null && nom.length() >= 5 && nom.length() <= 20)
            this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        if(prix >= 0)
            this.prix = prix;
    }

    public int getReduction() {
        return reduction;
    }

    public void setReduction(int reduction) {
        if (reduction >= 0 && reduction <= 80)
            this.reduction = reduction;
    }
}
