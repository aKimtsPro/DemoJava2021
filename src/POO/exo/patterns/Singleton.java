package POO.exo.patterns;

public class Singleton {

    /**
     * Variable d'instance privée
     */
    private static Singleton instance;

    private int variable;

    /**
     * Constructeur privé
     * @return
     */
    private Singleton() {
        this.variable = 5;
    }

    /**
     * Méthode publique d'accès à mon instance
     * @return
     */
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void faireQuelqueChose() {
        System.out.println("J'execute une action" + variable);
    }
}
