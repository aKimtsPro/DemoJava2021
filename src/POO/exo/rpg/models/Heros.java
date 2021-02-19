package POO.exo.rpg.models;



public abstract class Heros extends Personnage {

    protected int bonusEndu;
    protected int bonusForce;
    protected int orStocke;
    protected int cuirStocke;

    // ACTIONS

    public void seReposer() {
        this.pointsVie = this.pointsVieCreation;
        System.out.printf("%13s se repose et remonte ses PVs [%2d/%2d]",
                this.getClass().getSimpleName(),
                this.pointsVie,
                this.pointsVieCreation);
    }

    public void afficherInfos() {
        System.out.printf("%13s | PV [%2d/%2d] | FORCE : %2d | ENDU : %2d >> BONUS : +%d FORCE - %d ENDU >> GAINS : %3d po | %3d cuirs\n",
                this.getClass().getSimpleName(),
                this.pointsVie,
                this.pointsVieCreation,
                this.force,
                this.endurance,
                this.bonusForce,
                this.bonusEndu,
                this.orStocke,
                this.cuirStocke
                );
    }

    public void recolterRecompenses(Monstre monstre) {
           this.orStocke += monstre.getOr();
           this.cuirStocke += monstre.getCuir();
    }

    // GETTERS

    public int getOrStocke() {
        return orStocke;
    }

    public int getCuirStocke() {
        return cuirStocke;
    }
}
