package structures;

public abstract class Set {
    public abstract Pair find(String k) throws Exception;

    public abstract void put(Pair p) throws Exception;

    public abstract double read(String k) throws Exception;

    public abstract void edit(Pair p) throws Exception;

    public abstract void clean();

    public abstract int number();
}
