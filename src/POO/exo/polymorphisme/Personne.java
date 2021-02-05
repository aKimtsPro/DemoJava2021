package POO.exo.polymorphisme;

import java.time.Period;

public class Personne {

    public String nom;

    public void saluer(){
        System.out.println("Salut!");
    }

    public void saluer(Personne personne){
        System.out.println("Salut " +personne.nom + "!");
    }

    public void saluer(int iteration){
        for (int i = 0; i < iteration; i++) {
            saluer();
        }
    }

    public void saluer(Personne personne, int iteration){
        for (int i = 0; i < iteration; i++) {
            saluer(personne);
        }
    }

    public void saluer(int iteration, Personne personne){
        saluer(iteration - 1);
        saluer(personne);
    }
}
