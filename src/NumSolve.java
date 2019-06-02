public class NumSolve {
    public static void main(String[] args) {
        PolySolver polySolver = new PolySolver();

        Polynomial polynomial = new Polynomial();
        polynomial.addTerm(4, 3);
        polynomial.addTerm(2, 2);
        polynomial.addTerm(5, 1);
        polynomial.addTerm(-10, 0);

        Polynomial p2 = new Polynomial();
        p2.addTerm(2, 3);
        p2.addTerm(2, 2);
        p2.addTerm(15, 1);

        Polynomial subtracted = polynomial.subtract(p2);

        System.out.println(subtracted);

        System.out.println(polySolver.findRoot(subtracted, 0, 10, 3));

//        System.out.println(polySolver.getY(3, polynomial));
//        System.out.println(polynomial.getDerivative());
    }
}
