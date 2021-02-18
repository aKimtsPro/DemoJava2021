package POO.demo.enums;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DemoEnum {

    public static void main(String[] args) {

        System.out.println("modification dans l'original");

        System.out.println(Unite.CELCIUS.getFormattedTemperature(24));

        List<Thermometre> thermos = new ArrayList<>();
        thermos.add(new Thermometre(10, Unite.CELCIUS));
        thermos.add(new Thermometre(12, Unite.CELCIUS));
        thermos.add(new Thermometre(68, Unite.FAHRENHEIT));
        thermos.add(new Thermometre(280, Unite.KELVIN));
        thermos.add(new Thermometre(57, Unite.FAHRENHEIT));

        // CompareTo

        System.out.println("--- avant tri ---");
        thermos.forEach(System.out::println);
        thermos = thermos.stream()
                .sorted((t1, t2) -> t1.getUnite().compareTo(t2.getUnite()))
                .collect(Collectors.toList());
        System.out.println("--- apres tri ---");
        thermos.forEach(System.out::println);


        System.out.println("--- name() ---");
        System.out.println(Unite.CELCIUS.name());


        System.out.println("--- ordinal() ---");
        System.out.println( Unite.CELCIUS.ordinal() );


        Unite[] unitTab = Unite.values();
        Unite unitPart = Unite.valueOf("CELCIUS"); // ! IllegalArgumentException

    }
}
