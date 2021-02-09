package POO.exo.heritage.musique;

public class Classique extends Musique{
    public Classique(String nom, int longueur) {
        super(nom, longueur);
    }

    @Override
    public void jouer() {
        System.out.println("classique");

    }
}
