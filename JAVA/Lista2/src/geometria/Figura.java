package geometria;

public interface Figura {
    public abstract void przesun(Wektor v);

    public abstract void obroc(Punkt p, double kat);

    public abstract void odbij(Prosta p);


}
