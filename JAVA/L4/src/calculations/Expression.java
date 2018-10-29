/**
 * Klasa reprezentujaca wyrazenia ogolnie
 */

package calculations;

public abstract class Expression implements Calculable {

    /**
     * Zwraca sume argumentow podanych na wejsciu
     *
     * @param args
     * @return
     */

    public static double sum(Expression... args) {
        double res = 0f;
        for (Expression e :
                args) {
            res += e.calculate();
        }
        return res;
    }

    /**
     * Zwraca iloczyn argumentow podanych na wejsciu
     *
     * @param args
     * @return
     */

    public static double product(Expression... args) {
        double res = 1f;
        for (Expression e :
                args) {
            res *= e.calculate();
        }
        return res;
    }

    /**
     * Zwraca wartosc typu double wyrazenia e
     *
     * @return
     */

    public abstract double calculate();

    /**
     * Zwraca wyrazenie e w formie napisu typu String
     *
     * @return
     */

    public abstract String toString();

    /**
     * Porownuje wyrazenia (dwa wyrazenia sa identyczne, jezeli maja taka sama wartosc)
     *
     * @param obj
     * @return
     */

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Expression)) {
            return false;
        }
        return Double.compare(this.calculate(), ((Expression) obj).calculate()) == 0;
    }
}

