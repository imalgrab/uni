package calculations;

/**
 * Operator potegowania (wyrazenie e do potegi wyrazenie f)
 */

public class Pow extends BinaryOperator {

    public Pow(Expression e, Expression f) {
        super(e, f);
    }

    /**
     * @see BinaryOperator
     */

    @Override
    public String toString() {
        return e.toString() + "^" + f.toString();
    }

    /**
     * @see BinaryOperator
     */

    @Override
    public double calculate() {
        return Math.pow(e.calculate(), f.calculate());
    }
}
