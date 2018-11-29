package calculations;

/**
 * Operator dzielenia dwoch wyrazen (mianownik != 0)
 */

public class Divide extends BinaryOperator {

    public Divide(Expression e, Expression f) {
        super(e, f);
    }

    /**
     * @see BinaryOperator
     */

    @Override
    public String toString() {
        return e.toString() + " / " + f.toString();
    }

    /**
     * @see BinaryOperator
     */

    @Override
    public double calculate() throws IllegalArgumentException {
        if (f.calculate() == 0) {
            throw new IllegalArgumentException("Division by 0!");
        }
        return e.calculate() / f.calculate();
    }
}
