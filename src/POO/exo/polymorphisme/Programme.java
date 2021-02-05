package POO.exo.polymorphisme;

public class Programme {
    public static void main(String[] args) {

        Personne jp = new Personne();
        Personne jm = new Personne();
        jp.nom = "Jean-Pol";
        jm.nom = "Jean-Marie";

        jp.saluer();
        System.out.println();
        jp.saluer(3);
        System.out.println();
        jp.saluer(jm);
        System.out.println();
        jp.saluer(jm, 3);
        System.out.println();
        jp.saluer(3, jm);

    }
}
