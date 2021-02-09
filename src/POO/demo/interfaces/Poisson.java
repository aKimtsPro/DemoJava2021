package POO.demo.interfaces;

public abstract class Poisson extends Animal implements VieAquatique{

    private int nbrEcaille;

    public Poisson(int poid, int nbrEcaille) {
        super(poid);
        this.nbrEcaille = nbrEcaille;
    }
}
