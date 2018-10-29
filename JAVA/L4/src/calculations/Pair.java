package calculations;

/**
 * Reprezentacja par: (k:String, v:double)
 */

public class Pair {
    public final String key;
    private double value;

    /**
     * Konstruktor (uwzglednia wyjatek dla par z pustym kluczem)
     * @param key
     * @param value
     */

    public Pair(String key, double value) {
        isDataProper(key, value);
        this.key = key;
        this.value = value;
    }

    /**
     * Metoda pomocnicza do sprawdzenia poprawnosci danych w konstruktorze
     * @throws IllegalArgumentException
     */

    private void isDataProper(String key, double value) throws IllegalArgumentException {
        if (key == "") {
            throw new IllegalArgumentException("Key cannot be an empty string!");
        }
    }

    /**
     * getter dla wartosci
     * @return v
     */

    public double getValue() {
        return value;
    }

    /**
     * setter dla wartosci
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
     * nadpisana metoda equals
     * @param obj
     * @return true jeśli takie same klucze
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Pair)) return false;
        Pair p = (Pair) obj;
        return key == (p.key);
    }
}
