package POO.demo.collections;

import java.util.*;

public class DemoCollections {


    public static void main(String[] args) {
        testList();
    }

    public static void testList() {
        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        ints.forEach(i -> System.out.println(i));
        ints.removeIf(i -> i % 2 == 0);
        ints.forEach(i -> System.out.println(i));
    }
}
