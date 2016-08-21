
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
 * Compute intersections between sequence of discs.
 *
 * @author luisramalho
 *
 */
public final class L04E4NumberOfDiscIntersections {

    /**
     * L015NumberOfDiscIntersections is non-instantiable.
     */
    private L04E4NumberOfDiscIntersections() {

    }

    /**
     * Main method.
     *
     * @param args
     *            Arguments.
     */
    public static void main(final String[] args) {
        int[] a = { 1, 5, 2, 1, 4, 0 };
        System.out.println(solution(a));
    }

    /**
     * Computes intersections between sequence of discs.
     *
     * @param a
     *            array of N integers; N is an integer within the range
     *            [0..100,000]; each element of the array is an integer within
     *            the range [0..2147483647].
     * @return the number of pairs of intersecting discs.
     */
    public static int solution(final int[] a) {
        int intersectingPairs = 0;

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (j - i <= a[i] + a[j]) {
                    intersectingPairs++;
                }
            }
        }

        if (intersectingPairs > 10_000_000) {
            return -1;
        }
        return intersectingPairs;
    }

}
