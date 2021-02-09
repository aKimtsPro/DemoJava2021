package POO.demo.polymorphisme;

public class Guitariste {

    // Dans la classe: private
    // Et dans le package: package private
    // Et dans les enfants(héritage) : protected
    // Et partout : public

    private String nom = "Jules";
    protected String prenom;
    public int anneeExp; // = 0 par défaut
    public Guitare instrument;

    public Guitariste() {
        this.instrument = new Guitare(4, "classique", 2021);
    }

    public Guitariste(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        this.instrument = new Guitare(4, "classique", 2021);
    }

    public Guitariste(String nom, String prenom, int anneeExp, Guitare instrument) {
        this.nom = nom;
        this.prenom = prenom;
        this.anneeExp = anneeExp;
        this.instrument = instrument;
    }

    // Signature    - nom de la méthode
    //              - classe de la méthode
    //              - paramètres (types, ordre)

    // polymorphisme ad hoc - surcharge
    // polymorphisme paramètrique - généricité
    // -- polymorphisme d'héritage - spécialisation/surécriture (overriding)
    public void jouer(){ // Guitariste - jouer - /
        System.out.println(prenom +" "+ nom +" joue de la guitare(" +instrument.type+ ")." +
                "\nCa fait triling triling!");
    }

    public void jouer(Guitare instrument){ // Guitariste - jouer - Guitare
        System.out.println(prenom +" "+ nom +" joue de la guitare(" +instrument.type+ ")." +
                "\nCa fait triling triling!");
    }

    public void jouer(int prixEntree, Guitare instrument){  // Guitariste - jouer - int,Guitare
        System.out.println(prenom +" "+ nom +" fait un concert(" +instrument.type+ ")." +
                "\nLe prix d'entrée est de " + prixEntree);
    }

    public void jouer(Guitare instrument, int repetition){ // Guitariste - jouer - Guitare,int
        for (int i = 0; i < repetition; i++) {
            System.out.println(prenom +" "+ nom +" joue de la guitare(" +instrument.type+ ")." +
                    "\nCa fait triling triling!");
        }
    }
}
