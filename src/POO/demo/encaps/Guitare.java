package POO.demo.encaps;

public class Guitare {

    private int nbrCorde = 6;
    private String type;
    private int anneeConstruction;

    public Guitare(String type, int anneeConstruction) {
        this.type = type;
        this.anneeConstruction = anneeConstruction;
    }

    // lecture
    public int getNbrCorde(){
        return this.nbrCorde;
    }

    // ecriture
    void setNbrCorde(int nbrCorde){
        if(nbrCorde >= 0){
            this.nbrCorde = nbrCorde;
            System.out.println("le nombre de corde de la guitare ("+anneeConstruction+", "+type+") a été modifié");
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAnneeConstruction() {
        return anneeConstruction;
    }

    public void setAnneeConstruction(int anneeConstruction) {
        this.anneeConstruction = anneeConstruction;
    }
}
