package POO.demo.polymorphisme;

public class Guitare {

    int nbrCorde = 6;
    String type;
    int anneeConstruction;

    public Guitare(String type, int anneeConstruction) {
        this.type = type;
        this.anneeConstruction = anneeConstruction;
    }

    public Guitare(int nbrCorde, String type, int anneeConstruction) {
        this.nbrCorde = nbrCorde;
        this.type = type;
        this.anneeConstruction = anneeConstruction;
    }

    public void jouer(){
        System.out.println("Triling Triling");
    }
}
