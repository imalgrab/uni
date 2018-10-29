package calculations;

/**
 * Operator odwrotnosci wyrazenia e
 */

public class Reciprocal extends UnaryOperator {

    public Reciprocal(Expression e) {
        super(e);
    }

    /**
     * @see UnaryOperator
     */

    @Override
    public double calculate() throws IllegalArgumentException {
        if (e.calculate() == 0) {
            throw new IllegalArgumentException("Division by 0!");
        }
        return 1 / e.calculate();
    }

    /**
     * @see UnaryOperator
     */

    @Override
    public String toString() {
        return "1 / " + e.toString();
    }
}
