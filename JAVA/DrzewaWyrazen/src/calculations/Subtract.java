package calculations;

/**
 * Operator odejmowania dwoch wyrazen
 */

public class Subtract extends BinaryOperator {

    public Subtract(Expression e, Expression f) {
        super(e, f);
    }

    /**
     * @see BinaryOperator
     */

    @Override
    public String toString() {
        return e.toString() + " - " + f.toString();
    }

    /**
     * @see BinaryOperator
     */

    @Override
    public double calculate() {
        return e.calculate() - f.calculate();
    }
}
