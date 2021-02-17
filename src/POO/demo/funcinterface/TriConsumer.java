package POO.demo.funcinterface;

@FunctionalInterface
public interface TriConsumer<Integer, Double,  String> {
    void accept(Integer t, Double u, String v);
}
