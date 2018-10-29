package calculations;

/**
 * Operator maksimum z dwoch wyrazen
 */

public class Maximum extends BinaryOperator {

    public Maximum(Expression e, Expression f) {
        super(e, f);
    }

    /**
     * @see BinaryOperator
     */

    @Override
    public String toString() {
        return "max(" + e.toString() + ", " + f.toString() + ")";
    }

    /**
     * @see BinaryOperator
     */

    @Override
    public double calculate() {
        return Math.max(e.calculate(), f.calculate());
    }
}
