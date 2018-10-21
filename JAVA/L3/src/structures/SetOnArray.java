package structures;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SetOnArray extends Set {
    public Pair[] pairsArray;
    private int numOfPairs;
    private int currentIndex = 0;

    public SetOnArray(int numOfPairs) {
        this.pairsArray = new Pair[numOfPairs];
        this.numOfPairs = numOfPairs;
        isDataProper();
    }

    public SetOnArray() {
    }

    private void isDataProper() throws IllegalArgumentException {
        if (this.numOfPairs < 2) {
            throw new IllegalArgumentException("Size must be greater than 1");
        }
    }

    @Override
    public Pair find(String k) throws IllegalArgumentException {
        for (Pair p : pairsArray) {
            if (p.key == k) {
                return p;
            }
        }
        throw new IllegalArgumentException("There is no " + k + " in this set");
    }

    public boolean isInSet(Pair p) {
        for (Pair x :
                pairsArray) {
            if (p.equals(x)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void put(Pair p) throws IllegalArgumentException {
        if (isInSet(p)) {
            throw new IllegalArgumentException("This set already contains " + p.key);
        }
        this.pairsArray[currentIndex] = p;
        this.currentIndex++;
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

    @Override
    public void edit(Pair p) throws IndexOutOfBoundsException {
        if (isInSet(p)) {
            for (Pair x :
                    pairsArray) {
                if (p.equals(x)) {
                    x.setValue(p.getValue());
                }
            }
        } else if (numOfPairs <= currentIndex) {
            throw new IndexOutOfBoundsException("This set is full and you cannot add " + p.toString());
        } else put(p);
    }

    @Override
    public void clean() {
        this.pairsArray = new Pair[numOfPairs];
        currentIndex = 0;
    }

    @Override
    public int number() {
        return currentIndex;
    }
}
