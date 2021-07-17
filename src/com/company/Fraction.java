package com.company;

import java.math.BigInteger;

/**
 * A class representing fractions
 */
public class Fraction {
    final BigInteger numerator;
    final BigInteger denominator;

    /**
     * Constructor
     * @param numerator : numerator of the fraction
     * @param denominator : denominator of the fraction
     */
    public Fraction(BigInteger numerator, BigInteger denominator) {
        if(denominator.equals(BigInteger.ZERO)) {
            throw new ArithmeticException();
        }
        //Tu nalezy dac skracanie ulamka, najlepiej jak to sie dzieje w konstruktorze.
        this.numerator = numerator.divide(Primes.gcd(numerator,denominator));
        this.denominator = denominator.divide(Primes.gcd(numerator,denominator));
    }

    /**
     * Constructor which makes an integer from the string.
     * @param value : integer value
     */
    public Fraction(String value) {
        this.numerator = new BigInteger(value);
        this.denominator = BigInteger.ONE;
    }

    /**
     * Adds two fractions.
     * @param other : other fraction
     * @return this fraction plus other fraction
     */
    public Fraction add(Fraction other) {
        BigInteger newDenominator = denominator.multiply(other.denominator);
        BigInteger newNumerator = numerator.multiply(other.denominator).add(other.numerator.multiply(denominator));
        return new Fraction(newNumerator, newDenominator);
    }

    /**
     * Substracts two fractions.
     * @param other : other fraction
     * @return this fraction minus other fraction
     */
    public Fraction subtract(Fraction other) {
        BigInteger newDenominator = denominator.multiply(other.denominator);
        BigInteger newNumerator = numerator.multiply(other.denominator).subtract(other.numerator.multiply(denominator));
        return new Fraction(newNumerator, newDenominator);
    }

    /**
     * Multiplies two fractions.
     * @param other : other fraction
     * @return this fraction multiplied by other fraction
     */
    public Fraction multiply(Fraction other) {
        BigInteger newDenominator = denominator.multiply(other.denominator);
        BigInteger newNumerator = numerator.multiply(other.numerator);
        return new Fraction(newNumerator, newDenominator);
    }

    /**
     * Inverses the fraction.
     * @return this fraction inversed
     */
    public Fraction inverse() {
        return new Fraction(denominator,numerator);
    }

    /**
     * Divides this fraction by other fraction.
     * @param other : other fraction
     * @return this fraction divided by other fraction
     */
    public Fraction divide(Fraction other) {
        return multiply(other.inverse());
    }

    /**
     * Checks if this fraction is an integer.
     * @return is this fraction an integer?
     */
    public boolean isInteger() {
        return denominator.equals(BigInteger.ONE);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;

        if(obj.getClass() != Fraction.class)
            return false;

        Fraction other = (Fraction) obj;

        return other.numerator.equals(numerator) && other.denominator.equals(denominator);
    }

    @Override
    public String toString() {
        if(isInteger())
            return numerator.toString();
        else
            return numerator.toString() + "/" + denominator.toString();
    }

    /**
     * Checks if integer value is divisible by another integer value.
     * Of course if at least one of the values is not integer, returns false.
     * @param value : another integer value
     * @return is this integer divisible by other.
     */
    public boolean isDivisible(Fraction value) {
        return isInteger() && value.isInteger() && divide(value).isInteger();
    }
}
