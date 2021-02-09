package POO.exo.heritage.musique;

public class Rock extends Musique {
    public Rock(String nom, int longueur) {
        super(nom, longueur);
    }

    @Override
    public void jouer() {
        System.out.println("rock");

    }
}
