package com.company;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Class that does some work with primes.
 */
public class Primes {
    private static ArrayList<BigInteger> primes;

    /**
     * This method generates primes to some bound
     * @param n : bound
     */
    public static void generatePrimes(int n) {
        primes = new ArrayList<>();
        boolean[] numbers = new boolean[n];

        for(int i = 2; i < n; i++) {
            if(!numbers[i]) {
                primes.add(new BigInteger(Integer.toString(i)));
                for(int j = 2; j*i < n; j++)
                    numbers[i*j] = true;
            }
        }
    }

    /**
     * Getter
     * @return : primes generated
     */
    public static ArrayList<BigInteger> getPrimes() {
        return new ArrayList<>(primes);
    }

    /**
     * This metod gives a greatest common divisor of two integers
     * @param a : integer
     * @param b : integer
     * @return : gcd of those
     */
    public static BigInteger gcd(BigInteger a, BigInteger b) {
        if(b.equals(BigInteger.ZERO))
            return a;
        else
            return gcd(b, a.mod(b));
    }
}
