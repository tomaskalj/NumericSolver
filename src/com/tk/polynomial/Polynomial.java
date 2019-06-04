package com.tk.polynomial;

import java.util.LinkedList;
import java.util.List;

public class Polynomial {
    private List<Term> terms;

    public Polynomial() {
        terms = new LinkedList<>();
    }

    public void addTerm(Term term) {
        terms.add(term);
    }

    public void addTerm(int coefficient, int power) {
        addTerm(new Term(coefficient, power));
        terms.sort(Term::compareTo);
    }

    public double getY(double x) {
        double y = 0;

        for (Term term : terms) {
            y += term.getCoefficient() * Math.pow(x, term.getPower());
        }

        return y;
    }

    public Polynomial subtract(Polynomial other) {
        Polynomial polynomial = new Polynomial();

        int minTerms = Math.min(terms.size(), other.terms.size());
        int maxTerms = Math.max(terms.size(), other.terms.size());

        for (int i = 0; i < minTerms; i++) {
            Term t1 = terms.get(i);
            Term t2 = other.terms.get(i);

            Term newTerm = new Term(t1.getCoefficient() - t2.getCoefficient(), t1.getPower());
            polynomial.addTerm(newTerm);
        }

        if (maxTerms != minTerms) {
            for (int i = minTerms; i < maxTerms; i++) {
                Polynomial toUse = terms.size() == maxTerms ? this : other;
                polynomial.addTerm(toUse.terms.get(i));
            }
        }

        return polynomial;
    }

    public Polynomial getDerivative() {
        Polynomial derivative = new Polynomial();
        terms.forEach(term -> derivative.addTerm(term.derive()));
        return derivative;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < terms.size(); i++) {
            Term term = terms.get(i);
            if (term.toString().isEmpty()) {
                terms.remove(i--);
                continue;
            }

            if (i != 0) {
                str.append(term.getCoefficient() < 0 ? "-" : "+").append(" ");
            }

            str.append(term).append(" ");
        }

        return str.toString();
    }
}
