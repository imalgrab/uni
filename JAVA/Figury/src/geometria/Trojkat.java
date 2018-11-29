package geometria;

public class Trojkat implements Figura {

    Punkt a, b, c;

    public Trojkat(Punkt a, Punkt b, Punkt c) {
        this.a = a;
        this.b = b;
        this.c = c;
        czyDobre();
    }

    private void czyDobre() throws IllegalArgumentException {
        if (!Punkt.czyRozne(a, b) || !Punkt.czyRozne(b, c) || !Punkt.czyRozne(a, c)) {
            throw new IllegalArgumentException("Punkty musza byc rozne!");
        }
        if (czyWspoliniowe(a, b, c)) {
            throw new IllegalArgumentException("Punkty nie moga byc wspolliniowe!");
        }
    }

    private static boolean czyWspoliniowe(Punkt a, Punkt b, Punkt c) {

        //3 punkty są współliniowe jeżeli pole trójkąta jest równe 0

        double x1 = a.getX(), y1 = a.getY();
        double x2 = b.getX(), y2 = b.getY();
        double x3 = c.getX(), y3 = c.getY();

        double res = x1 * (y2 - y3) +
                x2 * (y3 - y1) +
                x3 * (y1 - y2);

        return res == 0;

        /*
        double AC = (b.getY() - a.getY()) / (b.getX() - a.getX());
        double AB = (c.getY() - a.getY()) / (c.getX() - a.getX());
        return AC == AB;
         */
    }

    public String toString() {
        return "a = (" + a.getX() + ", " + a.getY() +
                ")\nb = (" + b.getX() + ", " + b.getY() +
                ")\nc = (" + c.getX() + ", " + c.getY() + ")";
    }

    @Override
    public void przesun(Wektor v) {
        a.przesun(v);
        b.przesun(v);
        c.przesun(v);
    }

    @Override
    public void obroc(Punkt p, double kat) {
        a.obroc(p, kat);
        b.obroc(p, kat);
        c.obroc(p, kat);
    }

    @Override
    public void odbij(Prosta p) {
        a.odbij(p);
        b.odbij(p);
        c.odbij(p);
    }
}
