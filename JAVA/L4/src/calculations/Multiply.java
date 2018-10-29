package calculations;

/**
 * Operator iloczynu dwoch wyrazen
 */

public class Multiply extends BinaryOperator {

    public Multiply(Expression e, Expression f) {
        super(e, f);
    }

    /**
     * @see BinaryOperator
     */

    @Override
    public String toString() {
        return e.toString() + " * " + f.toString();
    }

    /**
     * @see BinaryOperator
     */

    @Override
    public double calculate() {
        return e.calculate() * f.calculate();
    }
}
