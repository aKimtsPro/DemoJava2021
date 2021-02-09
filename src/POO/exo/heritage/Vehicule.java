package POO.exo.heritage;

public abstract class Vehicule {

    private String marque;
    private String modele;
    private int puissance;

    public Vehicule(String marque, String modele, int puissance) {
        this.marque = marque;
        this.modele = modele;
        this.puissance = puissance;
    }

    public abstract void seDeplacer();

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        if(marque != null && marque.length() >= 5 && marque.length() <= 20)
            this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        if(puissance >= 0)
            this.puissance = puissance;
    }
}
