package POO.demo.heritage;

public class Velo extends Article {

    private int nbrRoue;

    public Velo(String marque, String nom, double prix, int nbrRoue) {
        super(marque, nom, prix);
        this.nbrRoue = nbrRoue;
    }

    public int getNbrRoue() {
        return nbrRoue;
    }

    public void setNbrRoue(int nbrRoue) {
        this.nbrRoue = nbrRoue;
    }

    @Override
    public void setPrix(double prix) {
        if(prix <= 250){
            super.setPrix(prix);
        }
    }

    @Override
    public void presenter() {
        System.out.println("Velo : " + getNom());
    }
}
