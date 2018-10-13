package geometria;

public class Punkt implements Figura {
    private double x, y;

    public Punkt(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Punkt() {
        x = 0;
        y = 0;
    }

    public String toString() {
        return ("(x, y) = (" + this.x + ", " + this.y + ")");
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public static boolean czyRozne(Punkt a, Punkt b) {
        if (a.x == b.x && a.y == b.y) {
            return false;
        }
        return true;
    }

    @Override
    public void przesun(Wektor v) {
        this.x += v.dx;
        this.y += v.dy;
    }

    @Override
    public void obroc(Punkt p, double kat) {
        x -= p.x;
        y -= p.y;
        double auxX = x * Math.cos(kat) - y * Math.sin(kat);
        double auxY = x * Math.sin(kat) + y * Math.cos(kat);
        x = auxX + p.x;
        y = auxY + p.y;
    }

    @Override
    public void odbij(Prosta p) {
        Prosta perpendicularToP = new Prosta(-p.B, p.A, p.B * x - p.A * y);
        Punkt intersectionOfPAndPerpToP = Prosta.getIntersection(p, perpendicularToP);
        Wektor przesuniecie = new Wektor(intersectionOfPAndPerpToP.getX() - x, intersectionOfPAndPerpToP.getY() - y);
        przesun(Wektor.dodajWektory(przesuniecie, przesuniecie));
    }
}
