/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Luís Ramalho
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

/**
 * Check whether two numbers have the same prime divisors.
 *
 * @author luisramalho
 */
public class L10E2CommonPrimeDivisors {

    /**
     * Check whether two numbers have the same prime divisors.
     *
     * @param a non-empty zero-indexed array of z integers. Z is an integer
     * within the range [1..6,000] and each element is an integer within the
     * range [1..2147483647].
     *
     * @param b non-empty zero-indexed array of z integers. Z is an integer
     * within the range [1..6,000] and each element is an integer within the
     * range [1..2147483647].
     *
     * @return the number of positions k for which the prime divisors of a[k]
     * and b[k] are exactly the same.
     */
    public int solution(int[] a, int[] b) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (samePrimeDivisors(a[i], b[i])) {
                count++;
            }
        }

        return count;
    }

    /**
     * Computes if a and b have the same prime divisors.
     *
     * @param a dividend
     * @param b divisor
     * @return <code>true</code> if a and b have the same prime divisors;
     * <code>false</code> otherwise.
     */
    private boolean samePrimeDivisors(int a, int b) {
        int gcd = gcd(a, b);

        while (gcd(a, gcd) != 1) {
            a /= gcd(a, gcd);
        }

        if (a != 1) {
            return false;
        }

        while (gcd(b, gcd) != 1) {
            b /= gcd(b, gcd);
        }

        // If both a and b are 1, then they have the same prime divisors.
        return a == b;
    }

    /**
     * Computes the greatest common divisor.
     *
     * @param a dividend
     * @param b divisor
     * @return the greatest common divisor.
     */
    private int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        } else {
            return gcd(b, a % b);
        }
    }

}
