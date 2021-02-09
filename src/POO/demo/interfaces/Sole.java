package POO.demo.interfaces;

public class Sole extends Poisson {

    private double epaisseur;

    public Sole(int poid, int nbrEcaille, double epaisseur) {
        super(poid, nbrEcaille);
        this.epaisseur = epaisseur;
    }

    @Override
    public void respirerSousLEau() {
        System.out.println("La sole respire sous l'eau comme une sole.");
    }

    @Override
    public void nager() {
        System.out.println("La sole nage comme une sole");
    }

}
