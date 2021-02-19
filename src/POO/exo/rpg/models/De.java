package POO.exo.rpg.models;

import java.util.Random;

public class De {

    private int minimum;
    private int maximum;
    private Random random;

    public De(int minimum, int maximum) {
        this.minimum = minimum == 0 ? 1 : Math.abs(minimum);
        this.maximum = Math.abs(maximum);
        this.random = new Random();
    }

    public int lancerDe() {
        int temp = this.random.nextInt(this.maximum + 1);
        return temp == 0 ? this.minimum : temp;
    }
}
