package calculations;

/**
 * Klasa abstrakcyjna reprezentujaca operator jednoargumentowy
 */

public abstract class UnaryOperator extends Expression {

    /**
     * Pole wyrazenie, na ktorym sa stosowane funkcje jak sin itp.
     */

    protected final Expression e;

    /**
     * Konstruktor
     *
     * @param e
     */

    public UnaryOperator(Expression e) {
        this.e = e;
    }

    /**
     * @see Expression
     */

    public abstract double calculate();

    /**
     * @see Expression
     */

    public abstract String toString();
}
