package POO.exo.heritage;

import java.time.LocalDate;
import java.util.Calendar;

public abstract class VehiculeARoue extends Vehicule {

    private int anneeConstr;
    private int nbrKmParcouru = 0;

    public VehiculeARoue(String marque, String modele, int puissance, int anneeConstr) {
        super(marque, modele, puissance);
        this.anneeConstr = anneeConstr;
    }

    public void seDeplacer(int nbrKm){
        System.out.println("Le vehicule à roue parcoure "+ nbrKm +"km.");
        nbrKmParcouru += nbrKm;
    }

    public int getAnneeConstr() {
        return anneeConstr;
    }

    public void setAnneeConstr(int anneeConstr) {
//        Calendar c = Calendar.getInstance();
//        int annee = c.get(Calendar.YEAR);

        if(anneeConstr <= LocalDate.now().getYear())
            this.anneeConstr = anneeConstr;
    }

    public int getNbrKmParcouru() {
        return nbrKmParcouru;
    }

    public void setNbrKmParcouru(int nbrKmParcouru) {
        if(nbrKmParcouru >= 0)
            this.nbrKmParcouru = nbrKmParcouru;
    }
}
