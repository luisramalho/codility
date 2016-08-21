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
 * Find the missing element in a given permutation.
 *
 * @author luisramalho
 *
 */

public final class L01E3PermMissingElem {

    /**
     * Private constructor.
     */
    private L01E3PermMissingElem() {
    }

    /**
     * Main method.
     *
     * @param args
     *            Arguments.
     */
    public static void main(final String[] args) {
        int[] ary = { 2, 3, 1, 5 };
        System.out.println(solution(ary));
    }

    /**
     * Finds the missing element in a given permutation.
     *
     * @param a
     *            Array
     * @return The value of the missing element.
     */
    private static int solution(final int[] a) {
        long n = a.length + 1;
        long expectedTotal = (n * (n + 1)) / 2;
        long actualTotal = 0;

        for (int i = 0; i < a.length; i++) {
            actualTotal += a[i];
        }

        int missingElement = (int) (expectedTotal - actualTotal);

        return missingElement;
    }

}