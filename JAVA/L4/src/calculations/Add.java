package calculations;

/**
 * Operator dodawania dwoch wyrazen
 */

public class Add extends BinaryOperator {

    public Add(Expression e, Expression f) {
        super(e, f);
    }

    /**
     * @see BinaryOperator
     */

    @Override
    public String toString() {
        return e.toString() + " + " + f.toString();
    }

    /**
     * @see BinaryOperator
     */

    @Override
    public double calculate() {
        return e.calculate() + f.calculate();
    }
}
