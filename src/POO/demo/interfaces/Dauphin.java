package POO.demo.interfaces;

public class Dauphin extends Mammifere implements Nageur {

    private double tailleAileron;

    public Dauphin(int poids, int nbrMammelle, double tailleAileron) {
        super(poids, nbrMammelle);
        this.tailleAileron = tailleAileron;
    }

    @Override
    public void nager() {
        System.out.println("Je nage comme un dauphin nage.");
    }


    public double getTailleAileron() {
        return tailleAileron;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Dauphin{");
        sb.append(", Poids=").append(poids);
        sb.append(", NombreMamelles=").append(nbrMammelle);
        sb.append(", tailleAileron=").append(tailleAileron).append('}');
        return sb.toString();
    }

    public void setTailleAileron(double tailleAileron) {
        this.tailleAileron = tailleAileron;


    }
}
