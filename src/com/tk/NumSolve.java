package com.tk;

import com.tk.approximation.PolySolver;
import com.tk.approximation.SimpsonSolver;
import com.tk.polynomial.Polynomial;

public class NumSolve {
    public static void main(String[] args) {
        PolySolver polySolver = new PolySolver();

//        Polynomial p1 = new Polynomial();
//        p1.addTerm(4, 3);
//        p1.addTerm(2, 2);
//        p1.addTerm(5, 1);
//        p1.addTerm(-10, 0);
//
//        Polynomial p2 = new Polynomial();
//        p2.addTerm(2, 3);
//        p2.addTerm(2, 2);
//        p2.addTerm(15, 1);
//
//        System.out.println(polySolver.findIntercept(p1, p2, 0, 10, 3));

        Polynomial polynomial = new Polynomial();
        polynomial.addTerm(1, -1);

        SimpsonSolver simpsonSolver = new SimpsonSolver();
        System.out.println(simpsonSolver.approximateIntegral(polynomial, 1, 2, 0.1));

        polynomial = new Polynomial();
        polynomial.addTerm(1, 2);

        System.out.println(simpsonSolver.approximateIntegral(polynomial, 1, 4, 0.3));
    }
}
