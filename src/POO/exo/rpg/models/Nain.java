package POO.exo.rpg.models;

public class Nain extends Heros {

    public Nain() {
        this.endurance = this.calculerStatDemarrage(lancerLesDes());
        this.force = calculerStatDemarrage(lancerLesDes());
        this.bonusEndu = 2;
        this.pointsVie = this.endurance + calculerModificateur(this.endurance + this.bonusEndu);
        this.pointsVieCreation = this.pointsVie;


        this.afficherInfos();
    }
}
