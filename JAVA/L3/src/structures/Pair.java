package structures;

/**
 *
 * Reprezentacja par (k, v)
 */

public class Pair {
    public final String key;
    private double value;

    /**
     * Konstruktor (uwzględnia wyjątek dla par z pustym kluczem)
     *
     * @param key
     * @param value
     */

    public Pair(String key, double value) {
        this.key = key;
        this.value = value;
        isDataProper();
    }

    /**
     * Metoda pomocnicza do sprawdzenia poprawności danych w konstruktorze
     *
     * @throws IllegalArgumentException
     */

    private void isDataProper() throws IllegalArgumentException {
        if (key == "") {
            throw new IllegalArgumentException("Key cannot be an empty string!");
        }
    }

    /**
     * getter dla wartości
     * @return v
     */

    public double getValue() {
        return value;
    }

    /**
     * setter dla wartości
     * @param value
     */

    public void setValue(double value) {
        this.value = value;
    }

    /**
     * nadpisana metoda toString
     * @return "(k,v)"
     */

    @Override
    public String toString() {
        return "(" + key + ", " + getValue() + ")";
    }

    /**
     * porównanie dwóch par
     * @param obj
     * @return true jeśli takie same klucze
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Pair)) return false;
        Pair p = (Pair) obj;
        return key.equals(p.key);
    }
}
