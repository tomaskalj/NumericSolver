package com.tk.polynomial;

public class Term implements Comparable {
    private int coefficient;
    private int power;

    public Term(int coefficient, int power) {
        this.coefficient = coefficient;
        this.power = power;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public int getPower() {
        return power;
    }

    public Term derive() {
        return new Term(coefficient * power, power - 1);
    }

    @Override
    public String toString() {
        if (coefficient == 0) {
            return "";
        }

        StringBuilder term = new StringBuilder();

        if (power != 0) {
            term.append("x");
            if (power != 1) {
                term.append("^").append(power);
            }
        }

        if (coefficient != 1) {
            term.insert(0, Math.abs(coefficient));
        }

        return term.toString();
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Term)) {
            return 0;
        }
        Term other = (Term) o;
        return -Integer.compare(power, other.power);
    }
}
