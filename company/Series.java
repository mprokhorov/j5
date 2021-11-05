package com.company;

import java.io.FileWriter;
import java.io.IOException;

public abstract class Series {
    int amount;
    double initial;
    double coefficient;

    public Series(int amount, double initial, double coefficient) {
        this.amount = amount;
        this.initial = initial;
        this.coefficient = coefficient;
    }

    public abstract double getElement(int idx);

    public double getSum() {
        double sum = 0;
        for (int i = 0; i < amount; i++) {
            sum += getElement(i);
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < amount; i++) {
            str.append(getElement(i) + " ");
        }
        return str.toString();
    }

    public void saveToFile(String path) throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        fileWriter.write(toString() + "\n" + getSum());
        fileWriter.close();
    }
}
