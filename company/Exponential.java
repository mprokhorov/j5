package com.company;

public class Exponential extends Series {
    public Exponential(int amount, double initial, double coefficient) {
        super(amount, initial, coefficient);
    }

    @Override
    public double getElement(int idx) {
        return initial * Math.pow(coefficient, idx);
    }

    /*@Override
    public double getSum() {
        return initial * (Math.pow(coefficient, amount) - 1) / (coefficient - 1);
    }*/
}
