package POO.demo.interfaces;

public class Mammifere extends Animal {

    private int nbrMammelle;

    public Mammifere(int poid, int nbrMammelle) {
        super(poid);
        this.nbrMammelle = nbrMammelle;
    }
}
