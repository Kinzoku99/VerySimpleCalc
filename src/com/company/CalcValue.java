package com.company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CalcValue {
    private final Fraction value;
    public final static CalcValue ZERO = new CalcValue(new Fraction("0"));
    public final static CalcValue ONE = new CalcValue(new Fraction("1"));
    private final static CalcValue TWO = new CalcValue(new Fraction("2"));

    public CalcValue(String value) {
        this.value = new Fraction(value);
    }

    public CalcValue(Fraction value) {
        this.value = value;
    }

    public CalcValue add(CalcValue other) {
        return new CalcValue(value.add(other.value));
    }

    public CalcValue subtract(CalcValue other) {
        return new CalcValue(value.subtract(other.value));
    }

    public CalcValue multiply(CalcValue other) {
        return new CalcValue(value.multiply(other.value));
    }

    public CalcValue divide(CalcValue other) {
        return new CalcValue(value.divide(other.value));
    }

    private boolean isDivisible(CalcValue other) {
        return value.isDivisible(other.getValue());

    }

    private CalcValue fastPow(CalcValue other) {
        if(other.equals(ZERO))
            return ONE;
        else if(other.isDivisible(TWO)) {
            CalcValue res = fastPow(other.divide(TWO));
            return res.multiply(res);
        }
        else {
            return fastPow(other.subtract(ONE)).multiply(this);
        }
    }

    public CalcValue pow(CalcValue other) {
        if(other.getValue().isInteger()) {
           return fastPow(other);
        }
        else{
            throw new ArithmeticException();
        }
    }

    public CalcValue factorial() {
        if(equals(ZERO))
            return ONE;
        else if(value.isInteger()) {
            return multiply(subtract(ONE).factorial());
        }
        else{
            throw new ArithmeticException();
        }
    }

    public Fraction getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;

        if(obj.getClass() != CalcValue.class)
            return false;

        CalcValue other = (CalcValue) obj;

        return other.getValue().equals(value);
    }
}
