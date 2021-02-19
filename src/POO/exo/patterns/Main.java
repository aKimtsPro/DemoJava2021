package POO.exo.patterns;

public class Main {
    public static void main(String[] args) {
        Singleton.getInstance().faireQuelqueChose();
        /**
         * Interdit à cause du private sur le constructeur
         */
        //Singleton singleton = new Singleton();
    }
}
