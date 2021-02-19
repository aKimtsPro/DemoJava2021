package POO.exo.rpg.models;

public class Humain extends Heros {

    public Humain() {
        this.force = calculerStatDemarrage(lancerLesDes());
        this.endurance = calculerStatDemarrage(lancerLesDes());
        this.bonusEndu = 1;
        this.pointsVie = this.endurance + calculerModificateur(this.endurance + this.bonusEndu);
        this.pointsVieCreation = this.pointsVie;
        this.bonusForce = 1;
        this.afficherInfos();
    }
}
