package calculations;

/**
 * Operator wartosci bezwzglednej
 */

public class Abs extends UnaryOperator {

    public Abs(Expression e) {
        super(e);
    }

    /**
     * @see UnaryOperator
     */

    @Override
    public double calculate() {
        return Math.abs(e.calculate());
    }

    /**
     * @see UnaryOperator
     */

    @Override
    public String toString() {
        return "|" + e.toString() + "|";
    }
}
