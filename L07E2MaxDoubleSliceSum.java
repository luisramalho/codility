
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
 * Find the maximal sum of any double slice.
 *
 * @author luisramalho
 *
 */
public final class L07E2MaxDoubleSliceSum {

    /**
     * L7E2MaxDoubleSliceSum is non-instantiable.
     */
    private L07E2MaxDoubleSliceSum() {

    }

    /**
     * Main method.
     *
     * @param args
     *            Arguments.
     */
    public static void main(final String[] args) {
        int[] a = { 3, 2, 6, -1, 4, 5, -1, 2 };
        System.out.println(solution(a));
    }

    /**
     * Finds the maximal sum of any double slice.
     *
     * @param a
     *            non-empty zero-indexed array consisting of N integers. N is an
     *            integer within the range [3..100,000]; each element of array A
     *            is an integer within the range [−10,000..10,000].
     * @return the maximal sum of any double slice.
     */
    public static int solution(final int[] a) {
        int n = a.length;
        int[] maxBeginning = new int[n];
        int[] maxEnding = new int[n];

        if (n == 3) {
            return 0;
        }

        for (int i = 1; i < n - 1; i++) {
            maxEnding[i] = Math.max(0, maxEnding[i - 1] + a[i]);
        }

        for (int i = n - 2; i > 0; i--) {
            maxBeginning[i] = Math.max(0, maxBeginning[i + 1] + a[i]);
        }

        int maximalSum = 0;
        int maxDoubleSlice = 0;
        for (int i = 1; i < n - 1; i++) {
            maximalSum = maxEnding[i - 1] + maxBeginning[i + 1];
            maxDoubleSlice = Math.max(maxDoubleSlice, maximalSum);
        }

        if (maxDoubleSlice < 0) {
            maxDoubleSlice = 0;
        }

        return maxDoubleSlice;
    }
}
