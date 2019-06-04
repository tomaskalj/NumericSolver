package com.tk.trig;

public abstract class TrigFunction {
    protected int coefficient;
    protected int power;

    public TrigFunction() {
        coefficient = power = 1;
    }

    public TrigFunction setCoefficient(int coefficient) {
        this.coefficient = coefficient;
        return this;
    }

    public abstract TrigFunction getDerivative();
}
