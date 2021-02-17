package POO.demo.services;


import POO.demo.services.models.Adresse;
import POO.demo.services.models.CheckPerson;
import POO.demo.services.models.CheckPersonService;
import POO.demo.services.models.Personne;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    static List<Personne> list;

    public static void main(String[] args) {

        list = DataGeneratorService.getInstance().getDataFromCSV();

//        for (Personne p : list) {
//            System.out.println(p);
//        }
        // 1ere approche
        //showPersonLivingIn(list, "New York");
        // 2eme approche
        //showPersonLivingBetweenZip(list, 1000, 2000) ;
        // 3eme approche
        //showPersonWithExternalClass(list, new CheckPersonService());
        // 4eme approche
//        showPersonWithExternalClass(list, new CheckPerson() {
//            @Override
//            public boolean checkCriteria(Personne p) {
//                return p.getPhones()[0].contains("52");
//            }
//        });
        // 5eme approche
        //showPersonWithExternalClass(list, p -> p.getAddress().getCity().equalsIgnoreCase("New York"));
       // showPersonWithExternalClass(list, p -> p.getAddress().getZip() >= 1000 && p.getAddress().getZip() <= 2000);
        // 6eme approche
       // showPersonWithFunctionalInterface(list, p -> p.getLastName().startsWith("G"));
        //showPerson(list, p -> System.out.println(p));
        // 7eme approche
        //showPersonWithAction(list, p -> p.getLastName().length() <= 6, p -> System.out.println(p));
        //showPersonWithAction(list, p -> p.getLastName().length() <= 6, p -> p.getPhones()[0], email -> System.out.println(email));

        // Approche finale
        list
                .stream()
                .filter(p -> p.getAddress().getState().equalsIgnoreCase("LA"))
                .map(Personne::getEmail)
                .forEach(System.out::println);


        List<Adresse> adresses = list.stream()
                                    .map(Personne::getAddress)
                                    .collect(Collectors.toList());

        adresses.forEach(System.out::println);

        Stream.iterate(1, x -> x + 1).limit(100).map(Math::sqrt).forEach(System.out::println);
    }

    /**
     * Critère de recherche
     */
    // 1ere approche : méthode cherchant sur une liste avec un critère
    public static void showPersonLivingIn(List<Personne> list, String criteria) {
        for (Personne p : list) {
            if (p.getAddress().getCity().equalsIgnoreCase(criteria)) {
                System.out.println(p);
            }
        }
    }

    // 2eme approche : méthode cherchant sur une liste avec un critère type range
    public static void showPersonLivingBetweenZip(List<Personne> list, int lowZip, int highZip) {
        for (Personne p: list) {
            if (lowZip <= p.getAddress().getZip() && highZip >= p.getAddress().getZip()) {
                System.out.println(p);
            }
        }
    }

    // 3eme approche : classe qui spécifie le critère de recherche
    public static void showPersonWithExternalClass(List<Personne> list, CheckPerson check) {
        for (Personne p : list) {
            if (check.checkCriteria(p)) {
                System.out.println(p);
            }
        }
    }

    // 4eme approche : classe anonyme specifiant le critère de recherche

    // 5eme approche : expression lambda spécifiant le critère de recherche

    // 6eme approche : interface fonctionnelle avec lambda expression
    public static void showPersonWithFunctionalInterface(List<Personne> list, Predicate<Personne> predicate) {
        for (Personne p : list) {
            if (predicate.test(p)) {
                System.out.println(p);
            }
        }
    }

    public static void showPerson(List<Personne> list, Consumer<Personne> consumer) {
        for (Personne p : list) {
            consumer.accept(p);
        }
    }

    // 7eme approche : ajouter l'action par une lambda au resultat satisfaisant le critère de recherche
    public static void showPersonWithAction(List<Personne> list, Predicate<Personne> predicate, Consumer<Personne> consumer) {
        for (Personne p : list) {
            if (predicate.test(p)) {
                consumer.accept(p);
            }
        }
    }

    public static void showPersonWithAction(List<Personne> list, Predicate<Personne> predicate, Function<Personne, String> function, Consumer<String> consumer) {
        for (Personne p : list) {
            if (predicate.test(p)) {
                String s = function.apply(p);
                consumer.accept(s);
            }
        }
    }

    public static <X,Y> void showPersonWithActionGeneric(List<X> list, Predicate<X> predicate, Function<X,Y> function, Consumer<Y> consumer) {
        for (X p : list) {
            if (predicate.test(p)) {
                Y s = function.apply(p);
                consumer.accept(s);
            }
        }
    }
}
