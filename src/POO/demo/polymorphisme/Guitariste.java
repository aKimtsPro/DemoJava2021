package POO.demo.polymorphisme;

public class Guitariste {

    private String nom;
    public String prenom;
    public int anneeExp; // = 0 par défaut
    public Guitare instrument = new Guitare(4, "classique", 2021);

    public Guitariste() {
    }

    public Guitariste(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public Guitariste(String nom, String prenom, int anneeExp, Guitare instrument) {
        this.nom = nom;
        this.prenom = prenom;
        this.anneeExp = anneeExp;
        this.instrument = instrument;
    }

    // Signature    - nom
    //              - classe
    //              - paramètres (types, ordre)

    // polymorphisme ad hoc - surcharge
    // polymorphisme paramètrique - généricité
    // -- polymorphisme d'héritage - spécialisation/surécriture (overriding)
    public void jouer(){
        System.out.println(prenom +" "+ nom +" joue de la guitare(" +instrument.type+ ")." +
                "\nCa fait triling triling!");
    }

    public void jouer(Guitare instrument){
        System.out.println(prenom +" "+ nom +" joue de la guitare(" +instrument.type+ ")." +
                "\nCa fait triling triling!");
    }

    public void jouer(int prixEntree, Guitare instrument){
        System.out.println(prenom +" "+ nom +" fait un concert(" +instrument.type+ ")." +
                "\nLe prix d'entrée est de " + prixEntree);
    }

    public void jouer(Guitare instrument, int repetition){
        for (int i = 0; i < repetition; i++) {
            System.out.println(prenom +" "+ nom +" joue de la guitare(" +instrument.type+ ")." +
                    "\nCa fait triling triling!");
        }
    }
}
