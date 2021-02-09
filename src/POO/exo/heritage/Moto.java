package POO.exo.heritage;

public class Moto extends VehiculeARoue {

    private String nom;

    public Moto(String marque, String modele, int puissance, int anneeConstr, String nom) {
        super(marque, modele, puissance, anneeConstr);
        this.nom = nom;
    }

    @Override
    public void seDeplacer() {
        seDeplacer(30);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
