package POO.exo.heritage.musique;

public class HipHop extends Musique{
    public HipHop(String nom, int longueur) {
        super(nom, longueur);
    }

    @Override
    public void jouer() {
        System.out.println("hiphop");
    }

}
