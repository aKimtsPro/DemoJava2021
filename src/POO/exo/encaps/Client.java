package POO.exo.encaps;

import java.util.Random;

public class Client {

    private String nom = "anonyme";
    private String prenom = "anonyme";
    private String numero;
    private String email;
    private double solde;

    public Client(String nom, String prenom) {
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setNumero(generateNumero());
    }

    public static String generateNumero(){
        Random random = new Random();
        String numero = "";
        for (int i = 0; i < 8; i++) {
            numero += (char)(random.nextInt(26) + 65);
        }
        return numero;
    }

    public void acheter(Article article){
        acheter(article, 1);
    }

    public void acheter(Article article, int quantite){

        if(article == null){
            System.out.println("Article invalide.");
            return;
        }

        if(quantite <= 0){
            System.out.println("Quantité invalide.");
            return;
        }

        double prixReel = article.getPrix() * article.getReduction() / 100;
        int achat = 0;
        while(solde >= prixReel && achat < quantite){
            solde -= prixReel;
            achat++;
        }

        if( achat > 0 ){
            if(achat < quantite)
            {
                System.out.println(prenom+" "+nom+" n'avez pas assez pour tout.");
            }
            System.out.println(prenom+" "+nom+" a acheté "+achat+" article(s) ("+article.getNom()+","+article.getMarque()+ ","+prixReel+")");
            System.out.println("Solde restant : " + solde);
        }
        else
        {
            System.out.println("Solde insuffisant pour le moindre achat");
        }

    }

    public void recharger(double montant){
        if(montant >= 0){
            solde += montant;
            System.out.println(prenom+" "+nom+" a rechargé son compte de " +montant+ "euro." +
                    "\nSolde actuel : "+solde);
        }
        else {
            System.out.println("Montant invalide.");
        }
    }

    // region Getter/Setter

    public String getNom() {
        return nom;
    }

    private void setNom(String nom) {
        if(nom != null)
            this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    private void setPrenom(String prenom) {
        if(prenom != null)
            this.prenom = prenom;
    }

    public String getNumero() {
        return numero;
    }

    private void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email != null && email.length() >= 8 && email.length() <= 20)
            this.email = email;
    }

    public double getSolde() {
        return solde;
    }

    private void setSolde(double solde) {
        if(solde >= 0)
            this.solde = solde;
    }

    // endregion
}
