package structures;

public class Pair {
    public final String key;
    private double value;

    public Pair(String key, double value) {
        this.key = key;
        this.value = value;
        isDataProper();
    }

    public void isDataProper() throws IllegalArgumentException {
        if (key.isEmpty()) {
            throw new IllegalArgumentException("Key cannot be an empty string!");
        }
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "(" + this.key + ", " + this.getValue() + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Pair)) return false;
        Pair p = (Pair) obj;
        return key.equals(p.key);
    }
}
