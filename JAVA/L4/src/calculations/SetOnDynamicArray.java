package calculations;

import java.util.Arrays;

public class SetOnDynamicArray extends Set {
    private static final int INITIAL_SIZE = 2;
    private int currentIndex = 0;
    private int currentSize = INITIAL_SIZE;
    public Pair[] pairsArray;

    /**
     * Konstruktor o zadanym rozmiarze 2
     */

    public SetOnDynamicArray() {
        pairsArray = new Pair[INITIAL_SIZE];
    }


    /**
     * Przy braku miejsca nadpisujemy tablice nowa - dwa razy dluzsza
     */

    private void resizeIfNeeded() {
        if (currentIndex >= currentSize) {
            pairsArray = Arrays.copyOf(pairsArray, currentSize * 2);
            currentSize *= 2;
        }
    }

    protected boolean isInSet(Pair p) {
        for (Pair x :
                pairsArray) {
            if (p.equals(x)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public Pair find(String k) throws Exception {
        return null;
    }

    @Override
    public void put(Pair p) throws IllegalArgumentException {
        if (isInSet(p)) {
            throw new IllegalArgumentException("This element already exists in this set!");
        } else {
            resizeIfNeeded();
            pairsArray[currentIndex] = p;
            currentIndex++;
        }
    }

    @Override
    public double read(String k) throws IllegalArgumentException {
        for (Pair p : pairsArray) {
            if (p.key == k) {
                return p.getValue();
            }
        }
        throw new IllegalArgumentException("This set doesn't contain a pair with key: " + k);
    }

    public void edit(Pair p) {
        if (isInSet(p)) {
            for (Pair x : pairsArray) {
                if (p.equals(x)) {
                    x.setValue(p.getValue());
                }
            }
        } else put(p);
    }

    @Override
    public void clean() {
        pairsArray = new Pair[INITIAL_SIZE];
        currentIndex = 0;
    }

    @Override
    public int number() {
        return currentIndex;
    }
}

