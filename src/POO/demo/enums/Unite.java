package POO.demo.enums;

public enum Unite {
    CELCIUS('C', 0),        // ordinal = 0
    FAHRENHEIT('F', 32),    // ordinal = 1
    KELVIN('K', 273.15);    // ordinal = 2

    private final char symbole;
    private final double valeurZero;

    Unite(char symbole, double valeurZero) {
        this.symbole = symbole;
        this.valeurZero = valeurZero;
    }

    public String getFormattedTemperature(double temperature){
        return temperature + " " + symbole + "°";
    }

    public char getSymbole() {
        return symbole;
    }

    public double getValeurZero() {
        return valeurZero;
    }

    @Override
    public String toString() {
        return "Unite{" +
                "symbole=" + symbole +
                ", valeurZero=" + valeurZero +
                '}';
    }
}
