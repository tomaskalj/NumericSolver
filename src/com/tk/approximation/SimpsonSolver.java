package com.tk.approximation;

import com.tk.polynomial.Polynomial;

public class SimpsonSolver {
    public double approximateIntegral(Polynomial polynomial, int lower, int upper, double h) {
        double sum = 0;

        int i = 0;
        double x = lower;

        while (x <= upper) {
            if (i == 0 || i == (int) ((upper - lower) / h)) {
                sum += polynomial.getY(x);
            } else if (i % 2 != 0) {
                sum += 4 * polynomial.getY(x);
            } else if (i % 2 == 0) {
                sum += 2 * polynomial.getY(x);
            }

            i++;
            x += h;
            x = Math.floor(x * 100000) / 100000;
        }

        return sum * (h / 3);
    }
}
