package geometria;

public class Prosta {
    public final double A, B, C;

    public Prosta(double a, double b, double c) {
        A = a;
        B = b;
        C = c;
    }

    public static Prosta przesun(Prosta p, Wektor v) {
        return new Prosta(p.C, p.B, p.C - (p.A * v.dx) - (p.B * v.dy));
    }

    public static boolean isParallel(Prosta a, Prosta b) {
        return a.A * b.B == b.A * a.B;
    }

    public static boolean isPerpendicular(Prosta a, Prosta b) {
        return a.A * b.A == -1 * a.B * b.B;
    }

    public static Punkt getIntersection(Prosta a, Prosta b) throws IllegalArgumentException {
        if (!isParallel(a, b)) {
            double w = a.A * b.B - b.A * a.B;
            double wx = (-a.C) * b.B + b.C * a.B;
            double wy = a.A * (-b.C) + b.A * a.C;

            return new Punkt(wx / w, wy / w);
        }
        throw new IllegalArgumentException("Parallel lines have no intersection!");
    }
}
