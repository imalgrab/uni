package calculations;

/**
 * Klasa reprezentujaca zmienne
 */

public class Variable extends Expression {

    private static final SetOnDynamicArray setOfElems = new SetOnDynamicArray();
    private String var;

    public Variable(String var) {
        isDataProper(var);
        this.var = var;
    }

    /**
     * Metoda sprawdzajaca czy podana wartosc zmiennej jest poprawna
     * @param var
     * @throws IllegalArgumentException
     */

    private void isDataProper(String var) throws IllegalArgumentException {
        if (var == "") {
            throw new IllegalArgumentException("Variable cannot be an empty String!");
        }
    }

    /**
     * Zwraca wartosc zmiennej
     * @return
     */

    public double getValue() {
        return setOfElems.read(var);
    }

    /**
     * Zmienia wartosc zmiennej
     * @param value
     */

    public void setValue(double value) {
        setOfElems.edit(new Pair(var, value));
    }

    /**
     * @see Expression
     */

    @Override
    public double calculate() {
        return setOfElems.read(var);
    }

    /**
     * @see Expression
     */

    @Override
    public String toString() {
        return var;
    }
}
