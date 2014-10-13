/*
 * The MIT License
 *
 * Copyright 2014 luisramalho.
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
package codility;

/**
 * There are N chocolates in a circle. Count the number of chocolates you will
 * eat.
 *
 * @author luisramalho
 */
public class L10E1ChocolatesByNumbers {

    /**
     * n and n are integers within the range [1..1,000,000,000].
     *
     * @param n represents the number of chocolates arranged in a circle,
     * numbered from 0 to N − 1.
     * @param m chocolates to be omitted.
     * @return the number of chocolates that you will eat.
     */
    public int solution(int n, int m) {
        return n / gcd(n, m);
    }

    /**
     * Greatest common divisor by dividing.
     *
     * @param n dividend
     * @param m divisor
     * @return the greatest common divisor.
     */
    public int gcd(int n, int m) {
        if (n % m == 0) {
            return m;
        } else {
            return gcd(m, n % m);
        }
    }

}
