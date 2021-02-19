package POO.exo.rpg.models;

public class Loup extends Monstre implements Depecable {

    public Loup() {
        this.force = calculerStatDemarrage(lancerLesDes());
        this.endurance = calculerStatDemarrage(lancerLesDes());
        this.pointsVie = this.endurance + calculerModificateur(this.endurance + this.bonusEndu);
        this.pointsVieCreation = this.pointsVie;
        this.cuir = new De(1,4).lancerDe();

        this.afficherInfos();
    }

    @Override
    public void depecer(Heros heros) {
        heros.cuirStocke += this.cuir;
        this.cuir -= this.cuir;
    }
}
