package calculations;

/**
 * Klasa abstrakcyjna reprezentujaca operator dwuargumentowy
 */

public abstract class BinaryOperator extends UnaryOperator {

    /**
     * Drugie pole, ktore dodaje drugi argument dla dzialan dwuargumentowych
     */

    protected final Expression f;

    /**
     * Konstruktor z dwoma wyrazeniami jako argumentami
     *
     * @param e
     * @param f
     */

    public BinaryOperator(Expression e, Expression f) {
        super(e);
        this.f = f;
    }

    /**
     * @see UnaryOperator
     */

    public abstract double calculate();

    /**
     * @see UnaryOperator
     */

    public abstract String toString();
}
