package POO.demo.heritage;

public abstract class Article {

    private String marque = "inconnue";
    private String nom = "inconnu";
    private double prix;
    private int reduction;

    public Article(String marque, String nom, double prix, int reduction) {
        this.marque = marque;
        this.nom = nom;
        this.prix = prix;
        this.reduction = reduction;
    }

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

    public abstract void presenter();

    @Override
    public boolean equals(Object obj) {
        if( !(obj instanceof Article ))
            return false;

        // obj est au moins un Article
        if( this.nom == ((Article) obj).nom && this.marque == ((Article) obj).marque )
            return true;

        return false;
    }

    @Override
    public String toString() {
        return "Article :" +
                "\n - nom : " + nom+
                "\n - marque: " + marque+
                "\n - prix : " + prix+
                "\n - reduction : " + reduction;
    }
}
