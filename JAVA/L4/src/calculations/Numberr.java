package calculations;

/**
 * Klasa reprezentujaca liczby rzeczywiste
 */

public class Numberr extends Expression {

    private double value;

    public Numberr(double value) {
        this.value = value;
    }

    /**
     * @see Expression
     */

    @Override
    public double calculate() {
        return value;
    }

    /**
     * @see Expression
     */

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
