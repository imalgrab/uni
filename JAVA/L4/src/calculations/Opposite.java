package calculations;

/**
 * Operator przeciwnosci wyrazenia e
 */

public class Opposite extends UnaryOperator {

    public Opposite(Expression e) {
        super(e);
    }

    /**
     * @see UnaryOperator
     */

    @Override
    public double calculate() {
        return -e.calculate();
    }

    /**
     * @see UnaryOperator
     */

    @Override
    public String toString() {
        return "-" + e.toString();
    }
}
