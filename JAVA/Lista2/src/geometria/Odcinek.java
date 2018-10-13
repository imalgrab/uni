package geometria;

public class Odcinek implements Figura {
    public Punkt b, e;

    public Odcinek(Punkt b, Punkt e) {
        this.b = b;
        this.e = e;
        czyDobre();
    }

    private void czyDobre() throws IllegalArgumentException {
        if (!Punkt.czyRozne(b, e)) {
            throw new IllegalArgumentException("Punkty musza byc rozne!");
        }
    }

    public String toString()
    {
        return "b = (" + b.getX() + ", " + b.getY() + ")"
                + "\ne = (" + e.getX() + ", " + e.getY() + ")";
    }

    @Override
    public void przesun(Wektor v) {
        b.przesun(v);
        e.przesun(v);
    }

    @Override
    public void obroc(Punkt p, double kat) {
        b.obroc(p, kat);
        e.obroc(p, kat);
    }

    @Override
    public void odbij(Prosta p) {
        b.odbij(p);
        e.odbij(p);
    }
}
