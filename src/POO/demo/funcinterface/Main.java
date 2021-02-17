package POO.demo.funcinterface;

public class Main {

    public static void main(String[] args) {

        TriConsumer test = (x,y,msg) -> {
            System.out.println(Integer.parseInt(x.toString()) + Double.parseDouble(y.toString()));
            System.out.println(msg);
        };

        testInterface(test, 5, 10, "Coucou");


    }

    public static void testInterface(TriConsumer consumer, int x, double y, String msg) {
        consumer.accept(x, y, msg);
    }
}
