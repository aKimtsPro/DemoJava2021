package POO.exo.rpg.models;

public abstract class Monstre extends Personnage {

    protected int or;
    protected int cuir;
    protected int bonusForce;
    protected int bonusEndu;

    public void afficherInfos() {
        System.out.printf("%13s | PV [%2d/%2d] | FORCE : %2d | ENDU : %2d >> BONUS : +%d FORCE - %d ENDU >> GAINS : %3d po | %3d cuirs\n",
                this.getClass().getSimpleName(),
                this.pointsVie,
                this.pointsVieCreation,
                this.force,
                this.endurance,
                this.bonusForce,
                this.bonusEndu,
                this.or,
                this.cuir
        );
    }

    public int getOr() {
        return or;
    }

    public int getCuir() {
        return cuir;
    }
}
