package POO.exo.heritage.vehicule;

public class Voiture extends VehiculeARoue {

    private int nbrPorte;

    public Voiture(String marque, String modele, int puissance, int anneeConstr, int nbrPorte) {
        super(marque, modele, puissance, anneeConstr);
        this.nbrPorte = nbrPorte;
    }

    public int getNbrPorte() {
        return nbrPorte;
    }

    public void setNbrPorte(int nbrPorte) {
        if(nbrPorte >= 0 && nbrPorte <= 5)
            this.nbrPorte = nbrPorte;
    }

    @Override
    public void seDeplacer() {
        seDeplacer(50);
    }
}
