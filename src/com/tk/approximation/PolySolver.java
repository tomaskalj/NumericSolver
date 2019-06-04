package com.tk.approximation;

import com.tk.polynomial.Polynomial;

public class PolySolver {
    public double findRoot(Polynomial polynomial, int xMin, int xMax, int accuracy) {
        double root = 0;

        for (int xm = xMin; xm < xMax * 100; xm++) {
            double x = (double) xm / 100;
            double y1 = polynomial.getY(x);
            double y2 = polynomial.getY(x + 0.1);

            if ((y1 < 0 && y2 > 0) || (y1 > 0 && y2 < 0)) {
                root = (2 * x + 0.1) / 2;
            }
        }

        Polynomial derivative = polynomial.getDerivative();

        for (int i = 0; i < accuracy; i++) {
            root = root - polynomial.getY(root) / derivative.getY(root);
        }

        return root;
    }

    public double findIntercept(Polynomial p1, Polynomial p2, int xMin, int xMax, int accuracy) {
        Polynomial polynomial = p1.subtract(p2);
        return findRoot(polynomial, xMin, xMax, accuracy);
    }
}
