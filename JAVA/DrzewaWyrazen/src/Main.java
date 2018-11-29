import calculations.*;

import java.lang.Number;

public class Main {
    public static void main(String[] args) {

        new Variable("x").setValue(2.0);

        Expression t1 = new Add(
                new Numberr(3),
                new Numberr(5));

        Expression t2 = new Add(
                new Numberr(2),
                new Multiply(
                        new Variable("x"),
                        new Numberr(7)
                )
        );

        Expression t3 = new Divide(
                new Subtract(
                        new Multiply(
                                new Numberr(3),
                                new Numberr(11)
                        ),
                        new Numberr(1)
                ),
                new Add(
                        new Numberr(7),
                        new Numberr(5)
                )
        );

        Expression t4 = new Arctan(
                new Divide(
                        new Multiply(
                                new Add(
                                        new Variable("x"),
                                        new Numberr(13)
                                ),
                                new Variable("x")
                        ),
                        new Numberr(2)
                )
        );

        Expression t5 = new Add(
                new Pow(
                        new Numberr(2),
                        new Numberr(5)
                ),
                new Multiply(
                        new Variable("x"),
                        new Log(
                                new Numberr(2),
                                new Variable("y"))
                )
        );

        //

        Expression t6 = new Reciprocal(
                new Opposite(
                        new Cosinus(
                                new Multiply(
                                        new Numberr(2),
                                        new Constant(Math.PI / 2)
                                )
                        )
                )

        );

        new Variable("y").setValue(3.0);

        System.out.println(t1.toString() + " : " + t1.calculate());
        System.out.println(t2.toString() + " : " + t2.calculate());
        System.out.println(t3.toString() + " : " + t3.calculate());
        System.out.println(t4.toString() + " : " + t4.calculate());
        System.out.println(t5.toString() + " : " + t5.calculate());
        System.out.println(t6.toString() + " : " + t6.calculate());
    }
}
