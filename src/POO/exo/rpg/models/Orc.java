package POO.exo.rpg.models;

public class Orc extends Monstre {

    public Orc() {
        this.force = calculerStatDemarrage(lancerLesDes());
        this.endurance = calculerStatDemarrage(lancerLesDes());
        this.pointsVie = this.endurance + calculerModificateur(this.endurance + this.bonusEndu);
        this.pointsVieCreation = this.pointsVie;
        this.bonusForce = 1;
        this.or = new De(1,4).lancerDe();
        this.afficherInfos();
    }
}
