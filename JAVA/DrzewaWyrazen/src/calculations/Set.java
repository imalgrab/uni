package calculations;

/**
 * Klasa abstrakcyjna reprezentujaca zbior
 */

public abstract class Set {

    /**
     * Wyszukuje pare o kluczu k
     * @param k
     * @return Pair p, t. że p.key == k
     * @throws Exception
     */
    public abstract Pair find(String k) throws Exception;

    /**
     * Dodaje pare do zbioru, powieksza miejsce jezeli musi
     * @param p
     * @throws Exception
     */

    public abstract void put(Pair p) throws Exception;

    /**
     * Wyszukuje pare o kluczu k
     * @param k
     * @return Pair p.getValue();
     * @throws Exception
     */

    public abstract double read(String k) throws Exception;

    /**
     * Nadpisuje wartosc pary o kluczu p.key lub dodaje te pare, jezeli nie ma takiego klucza
     * @param p
     * @throws Exception
     */

    public abstract void edit(Pair p) throws Exception;

    /**
     * Usuwa wszystkie pary ze zbioru
     */

    public abstract void clean();

    /**
     * Zwraca ilosc par w zbiorze
     * @return
     */

    public abstract int number();
}
