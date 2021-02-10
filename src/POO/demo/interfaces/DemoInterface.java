package POO.demo.interfaces;

import java.util.ArrayList;

public class DemoInterface {

    public static void main(String[] args) {

        Nageur nageur = new Dauphin(25 , 8, 15);
        ((Dauphin)nageur).nager();

    }
}
