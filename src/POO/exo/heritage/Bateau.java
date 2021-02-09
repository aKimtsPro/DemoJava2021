package POO.exo.heritage;

public class Bateau extends Vehicule {

    private int superficie;

    public Bateau(String marque, String modele, int puissance, int superficie) {
        super(marque, modele, puissance);
        this.superficie = superficie;
    }

    @Override
    public void seDeplacer() {
        System.out.println("ploof ploof le bateau.");
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        if(superficie >= 0)
            this.superficie = superficie;
    }
}
