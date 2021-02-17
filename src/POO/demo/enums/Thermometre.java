package POO.demo.enums;

public class Thermometre {

    private double value;
    private final Unite unite;

    public Thermometre(double value, Unite unite) {
        this.value = value;
        this.unite = unite;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Unite getUnite() {
        return unite;
    }

    @Override
    public String toString() {
        return "Thermometre{" +
                "value=" + value +
                ", unite=" + unite +
                '}';
    }
}
