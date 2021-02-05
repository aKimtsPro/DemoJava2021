package POO.demo.encaps;

public class DemoEncaps {

    public static void main(String[] args) {
        Guitare g = new Guitare("acoustique", 2020);

        System.out.println(g.getNbrCorde());

        g.setNbrCorde(-8);

        System.out.println(g.getNbrCorde());
    }
}
