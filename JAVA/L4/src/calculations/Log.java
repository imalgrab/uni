package calculations;

/**
 * Operator funkcji log o podstawie e i argumencie f
 */

public class Log extends BinaryOperator {

    public Log(Expression e, Expression f) {
        super(e, f);
    }

    /**
     * @see BinaryOperator
     */

    @Override
    public String toString() {
        return "log " + e.toString() + " (" + f.toString() + ")";
    }

    /**
     * @see BinaryOperator
     */

    @Override
    public double calculate() {
        return Math.log(f.calculate()) / Math.log(e.calculate()); //zamiana podstawy logarytmu
    }
}
