package POO.exo.classes;

import POO.exo.classes.Guitare;
import POO.exo.classes.Guitariste;

public class Main {

    public static void main(String[] args) {

        Guitariste guitariste1 = new Guitariste("marcy", "marc");
        Guitariste guitariste2 = new Guitariste("Pol", "Po");

        System.out.println(guitariste1.instrument);
        System.out.println(guitariste2.instrument);
        System.out.println(guitariste1.instrument == guitariste2.instrument);

        Guitare guitare = new Guitare("electrique", 2005);

        guitariste1.instrument = guitare;
        guitariste2.instrument = guitare;

        guitariste1.instrument.nbrCorde += 2;

        System.out.println("Instrument du guitariste 1 :" + guitariste1.instrument +
                "\n - nbrCorde : " + guitariste1.instrument.nbrCorde + // 8
                "\n - type : " + guitariste1.instrument.type +
                "\n - année de construction : " + guitariste1.instrument.anneeConstruction);

        System.out.println("Instrument du guitariste 2 : " + guitariste2.instrument +
                "\n - nbrCorde : " + guitariste2.instrument.nbrCorde + // 8
                "\n - type : " + guitariste2.instrument.type +
                "\n - année de construction : " + guitariste2.instrument.anneeConstruction);


    }
}
