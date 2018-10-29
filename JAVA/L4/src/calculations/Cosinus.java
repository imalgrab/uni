package calculations;

/**
 * Operator cosinus
 */

public class Cosinus extends UnaryOperator {

    public Cosinus(Expression e) {
        super(e);
    }

    /**
     * @see UnaryOperator
     */

    @Override
    public String toString() {
        return "cos(" + e.toString() + ")";
    }

    /**
     * @see UnaryOperator
     */

    @Override
    public double calculate() {
        return Math.cos(e.calculate());
    }
}
