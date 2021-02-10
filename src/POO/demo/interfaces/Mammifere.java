package POO.demo.interfaces;

public class Mammifere extends Animal {

    protected int nbrMammelle;

    public Mammifere(int poids, int nbrMammelle) {
        super(poids);
        this.nbrMammelle = nbrMammelle;
    }


}
