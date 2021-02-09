package POO.exo.heritage.production;

import java.util.Random;

public class Restaurant extends Propriete {

    private int moyenneClient;
    private int variance;
    private double prixPlat = 10;

    public Restaurant(Proprietaire proprietaire, int salaire, int nbrEmploye, int moyenneClient, int variance, double prixPlat) {
        super(proprietaire, salaire, nbrEmploye);
        this.setMoyenneClient(moyenneClient);
        this.setVariance(variance);
        this.setPrixPlat(prixPlat);
    }

    @Override
    public void produire() {
        int clientMidi = randomNbrClient();
        System.out.println("A midi, "+clientMidi+ " sont passé au restaurant.");
        int clientSoir = randomNbrClient();
        System.out.println("Au soir, "+clientSoir+ " sont passé au restaurant.");

        double gain = ((clientMidi+clientSoir)*this.getPrixPlat()) - (this.getNbrEmploye()*this.getSalaire());
        System.out.println("Aujourd'hui, "+getProprietaire().getPrenom()+ " "+getProprietaire().getNom()+" a gagné "+gain+ " euro(s).");
        getProprietaire().gain(gain);
    }

    private int randomNbrClient(){
        Random rdm = new Random();
        return moyenneClient-variance + rdm.nextInt(2*variance + 1);
    }

    public int getMoyenneClient() {
        return moyenneClient;
    }

    public void setMoyenneClient(int moyenneClient) {
        if(moyenneClient >= 0)
            this.moyenneClient = moyenneClient;
    }

    public int getVariance() {
        return variance;
    }

    public void setVariance(int variance) {
        if(variance <= this.moyenneClient && this.variance >= 0)
            this.variance = variance;
    }

    public double getPrixPlat() {
        return prixPlat;
    }

    public void setPrixPlat(double prixPlat) {
        if(prixPlat > 0)
            this.prixPlat = prixPlat;
    }
}
