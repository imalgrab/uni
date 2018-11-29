package calculations;

/**
 * Kolekcja obiektow Pair na tablicy statycznej
 * Kiedy nie ma miejsca na nowe elementy, wyjatek
 */

public class SetOnArray extends Set {
    public Pair[] pairsArray;
    private int numOfPairs;
    private int currentIndex = 0;

    /**
     * Konstruktor tworzy tablice o dlugosci numOfPairs
     *
     * @param numOfPairs
     */

    public SetOnArray(int numOfPairs) {
        isDataProper(numOfPairs);
        this.pairsArray = new Pair[numOfPairs];
        this.numOfPairs = numOfPairs;
    }

    public SetOnArray() {
    }

    private void isDataProper(int numOfPairs) throws IllegalArgumentException {
        if (numOfPairs < 2) {
            throw new IllegalArgumentException("Size must be greater than 1");
        }
    }

    /**
     * Wyszukuje pary o kluczu k
     *
     * @param k
     * @return Pair p
     * @throws IllegalArgumentException
     */

    @Override
    public Pair find(String k) throws IllegalArgumentException {
        for (Pair p : pairsArray) {
            if (p.key == k) {
                return p;
            }
        }
        throw new IllegalArgumentException("There is no " + k + " in this set");
    }

    /**
     * Pomocnicza metoda sprawdzania czy Pair p jest w zbiorze
     *
     * @param p
     * @return
     */

    protected boolean isInSet(Pair p) {
        for (Pair x :
                pairsArray) {
            if (p.equals(x)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Jezeli moze, dodaje pare do tablicy
     *
     * @param p
     * @throws IllegalArgumentException
     */

    @Override
    public void put(Pair p) throws IllegalArgumentException {
        if (isInSet(p)) {
            throw new IllegalArgumentException("This set already contains " + p.key);
        }
        this.pairsArray[currentIndex] = p;
        this.currentIndex++;
    }

    /**
     * Zwraca wartosc v Pair p o kluczu k
     *
     * @param k
     * @return value(p)
     * @throws IllegalArgumentException
     */

    @Override
    public double read(String k) throws IllegalArgumentException {
        for (Pair p : pairsArray) {
            if (p.key == k) {
                return p.getValue();
            }
        }
        throw new IllegalArgumentException("This set doesn't contain a pair with key: " + k);
    }

    /**
     * Nadpisuje wartosc pary p, jezeli taka jest juz w zbiorze
     * lub dodaje nowa pare jesli jest miejsce
     *
     * @param p
     * @throws IndexOutOfBoundsException
     */

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

    /**
     * Czysci zbior (usuwa z niego pary)
     */

    @Override
    public void clean() {
        this.pairsArray = new Pair[numOfPairs];
        currentIndex = 0;
    }

    /**
     * Zwraca ilosc elementow tablicy
     *
     * @return numOfPairs atm
     */

    @Override
    public int number() {
        return currentIndex;
    }
}
