package POO.exo.heritage.production;

public class Proprietaire {

    private String nom;
    private String prenom;
    private double solde;

    public Proprietaire(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public void gain(double montant){
        if(montant >= 0){
            setSolde(getSolde() + montant);
            System.out.println(prenom +" "+ nom + "a gagné " +montant+ "euro(s)");
        }
        else
            System.out.println("montant de gain invalide");

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public double getSolde() {
        return solde;
    }

    private void setSolde(double solde) {
        this.solde = solde;
    }
}
