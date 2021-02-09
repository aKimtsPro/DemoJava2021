package POO.demo.interfaces;

public class Grenouille extends Amphibien implements RespirateurAquatique {

    private String couleurPeau;

    public Grenouille(int poid, int taille, String couleurPeau) {
        super(poid, taille);
        this.couleurPeau = couleurPeau;
    }

    @Override
    public void respirerSousLEau() {
        System.out.println("La grenouille respire sous l'eau comme une grenouille");
    }
}
