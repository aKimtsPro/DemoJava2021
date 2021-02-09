package POO.exo.heritage.production;

public class Produit {

    private String nom = "Unkown";
    private double coutProd;
    private double prix;
    private double tempsProd = 1;

    public Produit(String nom, double coutProd, double prix, double tempsProd) {
        this.setNom(nom);
        this.setPrix(prix); // verification prix >= 0
        this.setCoutProd(coutProd); // verification coutProduction <= prix
        this.setTempsProd(tempsProd);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        if(nom != null)
            this.nom = nom;
    }

    public double getCoutProd() {
        return coutProd;
    }

    public void setCoutProd(double coutProd) {
        if(coutProd >= 0 && coutProd <= this.prix)
            this.coutProd = coutProd;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        if(prix >= this.coutProd)
            this.prix = prix;
        else{
            System.out.println("prix invalide");
            this.prix = this.coutProd;
        }
    }

    public double getTempsProd() {
        return tempsProd;
    }

    public void setTempsProd(double tempsProd) {
        if(tempsProd > 0 && tempsProd <= 8)
            this.tempsProd = tempsProd;
    }
}
