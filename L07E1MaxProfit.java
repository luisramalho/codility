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
 * Given a log of stock prices compute the maximum possible earning.
 *
 * @author luisramalho
 *
 */
public final class L07E1MaxProfit {

    /**
     * L7E1MaxProfit is non-instantiable.
     */
    private L07E1MaxProfit() {

    }

    /**
     * Main method.
     *
     * @param args
     *            Arguments.
     */
    public static void main(final String[] args) {
        int[] a = { 23171, 21011, 21123, 21366, 21013, 21367 };
        System.out.println(solution(a)); // 356
    }

    /**
     *
     * @param a
     *            Zero-indexed array consisting of N integers. N is an integer
     *            within the range [0..400,000]; each element of array A is an
     *            integer within the range [0..200,000].
     * @return the maximum possible profit from one transaction during this
     *         period; <code>0</code> if it was impossible to gain any profit.
     */
    public static int solution(final int[] a) {
        int maxProfit = 0;
        int maxSlice = 0;

        for (int i = 1; i < a.length; i++) {
            maxProfit = Math.max(0, maxProfit + (a[i] - a[i - 1]));
            maxSlice = Math.max(maxSlice, maxProfit);
        }

        if (maxSlice < 0) {
            maxSlice = 0;
        }

        return maxSlice;
    }

}
