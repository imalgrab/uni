package geometria;

public class Main {
    public static void main(String[] args) {
        Punkt A = new Punkt(0, 0);
        Punkt B = new Punkt(4, 0);
        Punkt C = new Punkt(0, 3);

        //System.out.println(Prosta.isParallel(new Prosta(1, -1, 2), new Prosta(1, -1, -7))); //sprawdzam dzialanie funkcji dla prostych rownoleglych

        //System.out.println(Prosta.isPerpendicular(new Prosta(1, -1, 3), new Prosta(-1, -1, 0))); //sprawdzam dzialanie funkcji dla prostych prostopadlych

        //System.out.println(Prosta.getIntersection(new Prosta(1, -1, 0), new Prosta(-1, -1, 0))); //sprawdzam dzialanie funkcji zwracajacej p.p. prostych nierownoleglych

        System.out.println("\n" + B.toString());
        B.odbij(new Prosta(1, -1, 0));
        System.out.println("Odbijam punkt wzgledem prostej y = x");
        System.out.println(B.toString());

        System.out.println();

        A = new Punkt(0, 0);
        B = new Punkt(4, 0);
        C = new Punkt(0, 3);

        Odcinek odAdoB = new Odcinek(A, B); //tworze odcinek ab
        System.out.println(odAdoB.toString());
        odAdoB.przesun(new Wektor(4, 2)); //przesuwam go o wektor [4, 2]
        System.out.println("Przesuwam odcinek o wektor [4, 2]");
        System.out.println(odAdoB.toString());

        System.out.println();

        Trojkat t1 = new Trojkat(A, B, C);  //tworze trojkat abc
        System.out.println(t1.toString());
        t1.przesun(new Wektor(10, -2));  //przesuwam go o wektor [10, -2]
        System.out.println("Przesuwam trojkat o wektor [10, -2]");
        System.out.println(t1.toString());

        System.out.println();

        System.out.println(A.toString());
        A.obroc(new Punkt(0, 0), -Math.PI / 2);
        System.out.println("Obracam punkt A wokol punktu (0, 0) o kat -90 stopni (90 stopni w prawo)");
        System.out.println(A.toString());

        System.out.println();
    }
}
