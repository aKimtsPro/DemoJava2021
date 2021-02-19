package POO.exo.rpg.models;

import java.util.Arrays;

public abstract class Personnage {

    protected int endurance;
    protected int force;
    protected int pointsVie;
    protected int pointsVieCreation;

    protected De de;
    protected boolean estMort;

    // ACTIONS

    protected int calculerStatDemarrage(int[] data) {
        Arrays.sort(data);
        data[0] = 0;
        int output = 0;
        for(int i : data) {
            output+=i;
        }

        return output;
    }

    protected int[] lancerLesDes() {
        int[] output = new int[4];

        de = new De(1, 6);

        for (int i = 0; i < output.length; i++) {
            output[i] = de.lancerDe();
        }

        return output;
    }

    protected int calculerModificateur(int modificateur) {
        if (modificateur < 5) {
            modificateur = -1;
        } else if (modificateur < 10) {
            modificateur = 0;
        } else if (modificateur < 15) {
            modificateur = 1;
        } else {
            modificateur = 2;
        }
        return  modificateur;
    }

    public void frapper(Personnage cible) {
        int degat;
        de = new De(1,4);
        if (this.getClass().getSimpleName().equalsIgnoreCase("Humain") || this.getClass().getSimpleName().equalsIgnoreCase("Nain")) {
            Heros hero = (Heros)this;
            degat = de.lancerDe() + calculerModificateur(this.getForce() + hero.bonusForce);
        } else {
            Monstre monstre = (Monstre)this;
            degat = de.lancerDe() + calculerModificateur(this.getForce() + monstre.bonusForce);
        }

        System.out.printf("\n%13s frappe %13s avec %2d DEGATS\n", this.getClass().getSimpleName(), cible.getClass().getSimpleName(), degat);

        cible.pointsVie -= degat;

        if (cible.pointsVie <= 0) {
            cible.mort();
        }

//        if (cible instanceof Monstre) {
//            ((Monstre)cible).afficherInfos();
//        } else if (cible instanceof Heros) {
//            ((Heros)this).afficherInfos();
//        }


    }

    // GETTERS AND SETTERS
    public int getEndurance() {
        return endurance;
    }

    public int getForce() {
        return force;
    }

    public int getPointsVieCreation() {
        return pointsVieCreation;
    }

    public int getPointsVie() {
        return pointsVie;
    }

    public void setPointsVie(int pointsVie) {
        this.pointsVie = pointsVie;
    }

    public boolean isEstMort() {
        return estMort;
    }

    protected void mort() {
        this.estMort = true;
        System.out.printf("\n%40s a succombé de ses blessures !!!", this.getClass().getSimpleName());
    }
}
