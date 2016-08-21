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
 * Solution for TapeEquilibrium.
 *
 * @author luisramalho
 *
 */
public final class L01E2TapeEquilibrium {

    /**
     * Test case(s).
     */
    static final int[] ARY = { 3, 1, 2, 4, 3 };

    /**
     * Private constructor.
     */
    private L01E2TapeEquilibrium() {

    }

    /**
     * Main method.
     *
     * @param args
     *            arguments
     */
    public static void main(final String[] args) {
        System.out.println(solution(ARY));
    }

    /**
     * Solution.
     *
     * @param a
     *            non-empty zero-indexed array, consisting of N integers.
     * @return The minimal difference that can be achieved.
     */
    private static int solution(final int[] a) {
        int totalSum = 0;
        for (int i = 0; i < a.length; i++) {
            totalSum += a[i];
        }

        int leftSum = 0;
        int rightSum = totalSum;
        int lowest = Integer.MAX_VALUE;
        int absDiff = 0;

        for (int i = 0; i < a.length - 1; i++) {
            leftSum += a[i];
            rightSum -= a[i];
            absDiff = Math.abs(leftSum - rightSum);
            if (absDiff < lowest) {
                lowest = absDiff;
            }
        }
        return lowest;
    }

}
