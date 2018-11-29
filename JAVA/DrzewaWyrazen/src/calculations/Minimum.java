package calculations;

/**
 * Operator minimum z dwoch wyrazen
 */

public class Minimum extends BinaryOperator {

    public Minimum(Expression e, Expression f) {
        super(e, f);
    }

    /**
     * @see BinaryOperator
     */

    @Override
    public String toString() {
        return "min(" + e.toString() + ", " + f.toString() + ")";
    }

    /**
     * @see BinaryOperator
     */

    @Override
    public double calculate() {
        return Math.min(e.calculate(), f.calculate());
    }
}
