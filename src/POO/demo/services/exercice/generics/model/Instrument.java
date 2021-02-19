package POO.demo.services.exercice.generics.model;


import POO.demo.services.exercice.todo.models.Model;

public class Instrument implements Model {

    public enum Type{ VENT, PERCUSSION, CORDE }

    private int id;
    private String marque;
    private String modele;
    private double prix;
    private Type type;

    public Instrument(int id, String marque, String modele, double prix, Type type) {
        this.id = id;
        this.marque = marque;
        this.modele = modele;
        this.prix = prix;
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Instrument{" +
                "id=" + id +
                ", marque='" + marque + '\'' +
                ", modele='" + modele + '\'' +
                ", prix=" + prix +
                ", type=" + type +
                '}';
    }
}
