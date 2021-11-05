package com.company;

public class Linear extends Series {
    public Linear(int amount, double initial, double coefficient) {
        super(amount, initial, coefficient);
    }

    @Override
    public double getElement(int idx) {
        return initial + coefficient * idx;
    }

    /*@Override
    public double getSum() {
        return (initial + getElement(amount - 1)) * amount / 2;
    }*/
}
