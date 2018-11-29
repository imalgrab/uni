package calculations;

/**
 * Operator sinus
 */

public class Sinus extends UnaryOperator {

    public Sinus(Expression e) {
        super(e);
    }

    /**
     * @see UnaryOperator
     */

    @Override
    public String toString() {
        return "sin(" + e.toString() + ")";
    }

    /**
     * @see UnaryOperator
     */

    @Override
    public double calculate() {
        return Math.sin(e.calculate());
    }
}
