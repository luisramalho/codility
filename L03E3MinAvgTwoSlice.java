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
 * Find the minimal average of any slice containing at least two elements.
 *
 * @author luisramalho
 *
 */
public final class L03E3MinAvgTwoSlice {

    /**
     * Private constructor.
     */
    private L03E3MinAvgTwoSlice() {

    }

    /**
     * Main method.
     *
     * @param args
     *            Arguments
     */
    public static void main(final String[] args) {
        int[] a = { 4, 2, 2, 5, 1, 5, 8 };
        System.out.println(solution(a));
    }

    /**
     * Computes the minimal average of any slice containing at least two
     * elements.
     *
     * @param a
     *            Non-empty zero-indexed array consisting of N integers.
     * @return the starting position of the slice with the minimal average.
     */
    public static int solution(final int[] a) {
        double min = Double.MAX_VALUE;
        double minCandidate = 0;
        int startPoint = 0;
        int[] p = prefixSum(a);

        // Only check slices with length 2 and 3
        for (int i = 0; i < a.length - 2; i++) {
            for (int j = 2; j < 4; j++) {
                minCandidate = (p[i + j] - p[i]) / (double) j;
                if (minCandidate < min) {
                    min = minCandidate;
                    startPoint = i;
                }
            }
        }

        // Computes the average of last 2 prefix sum numbers
        minCandidate = (p[a.length] - p[a.length - 2]) / 2.0;
        if (minCandidate < min) {
            min = minCandidate;
            startPoint = a.length - 2;
        }

        return startPoint;
    }

    /**
     * Computes prefix sum of array a.
     *
     * @param a
     *            array for which prefix sum is computed.
     * @return prefix sum array.
     */
    private static int[] prefixSum(final int[] a) {
        int n = a.length;
        int[] p = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            p[i] = p[i - 1] + a[i - 1];
        }
        return p;
    }

}
