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
 * Computes the number of integers divisible by k in range [a..b].
 *
 * @author luisramalho
 *
 */
public final class L03E4CountDiv {

    /**
     * Private constructor.
     */
    private L03E4CountDiv() {

    }

    /**
     * Main method.
     *
     * @param args
     *            Arguments.
     */
    public static void main(final String[] args) {
        int s = solution(6, 11, 2);
        System.out.println(s);
    }

    /**
     * Computes the number of integers divisible by k in range [a..b].
     *
     * { i : a ≤ i ≤ b, i mod k = 0 }
     *
     * @param a
     *            integer within the range [0..2,000,000,000]
     * @param b
     *            integer within the range [0..2,000,000,000]
     * @param k
     *            integer within the range [1..2,000,000,000]
     * @return the number of integers within the range [A..B] that are divisible
     *         by K
     */
    public static int solution(final int a, final int b, final int k) {
        int n = (b / k) - (a / k);
        if (a % k == 0) {
            n++;
        }
        return n;
    }

}
