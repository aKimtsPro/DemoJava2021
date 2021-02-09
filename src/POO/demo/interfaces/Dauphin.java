package POO.demo.interfaces;

public class Dauphin extends Mammifere implements Nageur {

    private double tailleAileron;

    public Dauphin(int poid, int nbrMammelle, double tailleAileron) {
        super(poid, nbrMammelle);
        this.tailleAileron = tailleAileron;
    }

    @Override
    public void nager() {
        System.out.println("Je nage comme un dauphin nage.");
    }
}
