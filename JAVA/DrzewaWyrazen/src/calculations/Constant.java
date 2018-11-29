package calculations;

/**
 * Klasa reprezentujaca stale (Pi, Fi, e)
 */

public class Constant extends Expression {

    private final double value;

    /**
     * Konstruktor, przyjmujacy wartosc typu double
     *
     * @param value
     */

    public Constant(double value) {

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
