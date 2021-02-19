package POO.exo.rpg;

import POO.exo.rpg.models.*;

import java.util.*;
import java.util.ArrayList;

public class Game {

    List<Heros> heros = new ArrayList<>();
    List<Monstre> monstres = new ArrayList<>();

    public Game() {
        this.demarrerJeu();
    }

    private void demarrerJeu() {
        creerEntites();
        lancerLesCombats();
    }

    private void lancerLesCombats() {
        do {
            lancerCombatEquipe(heros, monstres.get(new De(1, monstres.size()).lancerDe() - 1));
        } while (!heros.isEmpty() && !monstres.isEmpty());
        afficherFinJeu();
    }

    private void lancerCombatEquipe(List<Heros> heros, Monstre monstre) {

        Heros temp;

        do {
            temp = heros.get(new De(1, 2).lancerDe() - 1);
            if (!temp.isEstMort()) {
                temp.frapper(monstre);
            }
            if (!monstre.isEstMort()) {
                monstre.frapper(heros.get(heros.indexOf(temp)));
            }

        } while (!monstre.isEstMort() && !temp.isEstMort());

        if (monstre.isEstMort()) {
            monstres.remove(monstre);
            temp.recolterRecompenses(monstre);
            temp.seReposer();
        }
        if (temp.isEstMort()) {
            heros.remove(temp);
        }

    }

    private void creerEntites() {

        heros.add(new Humain());
        heros.add(new Nain());

        monstres.add(new Loup());
        monstres.add(new Orc());
        monstres.add(new Dragonnet());
    }

    private void afficherFinJeu() {
        System.out.printf("\n%50s | %15s\n\n", "FIN DU JEU", "STATISTIQUES FINALES");
        if (!heros.isEmpty()) {
            for(Heros h: heros) {
                h.afficherInfos();
            }
        } else {
            for(Monstre m: monstres) {
                m.afficherInfos();
            }
        }
    }
}
