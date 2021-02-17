package POO.demo.services.exercice;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Optional<Double> value = Stream.iterate(1, x -> x + 1)
                .limit(1000)
                .filter(x -> x % 2 == 1)
                .map(x -> Math.pow(x, 2))
                .reduce(Double::sum);

        value.ifPresent(System.out::println);


    }
    /**
     * Avec les streams,
     * créer une collection de 1 à 1000.
     * Vous ne gardez que les nombre impairs que vous mettez au carré et vous me calculer la somme totale
     */
}
