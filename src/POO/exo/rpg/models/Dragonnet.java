package POO.exo.rpg.models;

public class Dragonnet extends Monstre implements Depecable {

    public Dragonnet() {
        this.force = calculerStatDemarrage(lancerLesDes());
        this.endurance = calculerStatDemarrage(lancerLesDes());
        this.bonusEndu = 1;
        this.pointsVie = this.endurance + calculerModificateur(this.endurance + this.bonusEndu);
        this.pointsVieCreation = this.pointsVie;
        this.bonusForce = 1;
        this.or = new De(1,6).lancerDe();
        this.cuir = new De(1,4).lancerDe();
        this.afficherInfos();
    }

    @Override
    public void depecer(Heros heros) {
        heros.cuirStocke = this.cuir;
        this.cuir -= this.cuir;
    }
}
