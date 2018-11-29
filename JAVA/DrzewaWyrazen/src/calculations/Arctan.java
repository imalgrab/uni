package calculations;

/**
 * Operator arctan
 */

public class Arctan extends UnaryOperator {

    public Arctan(Expression e) {
        super(e);
    }

    /**
     * @see UnaryOperator
     */

    @Override
    public String toString() {
        return "arctg(" + e.toString() + ")";
    }

    /**
     * @see UnaryOperator
     */

    @Override
    public double calculate() {
        return Math.atan(e.calculate());
    }
}
