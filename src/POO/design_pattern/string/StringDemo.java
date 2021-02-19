package POO.design_pattern.string;

public class StringDemo {

    public static void main(String[] args) {

        System.out.println("a" == "a");                     // true
        System.out.println("a" == "b");                     // false
        System.out.println("a" == new String("a"));  // false
        System.out.println("a"+"b" == "ab");                // true

        /////////////////////////////////////////////////
        String a = "a"; // 1 instanciation
        StringBuilder builder = new StringBuilder(5000); // 2 instanciations


        for (int i = 0; i < 500000000; i++) {
            builder.append(a);
        }

        String rslt = builder.toString(); // 3 instanciations



    }
}
