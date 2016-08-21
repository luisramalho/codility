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

import java.util.HashSet;
import java.util.Set;

/**
 * Checks whether array a is a permutation.
 *
 * @author luisramalho
 *
 */
public final class L02E1PermCheck {

    /**
     * Private constructor.
     */
    private L02E1PermCheck() {
    }

    /**
     * Main method.
     *
     * @param args
     *            Arguments
     */
    public static void main(final String[] args) {
        int[] test = { 4, 1, 3, 2 };
        System.out.println(solution(test));
    }

    /**
     * Checks whether array a is a permutation.
     *
     * @param a
     *            Non-empty zero-indexed array.
     * @return <code>1</code> if array a is a permutation; <code>0</code>
     *         otherwise.
     */
    public static int solution(final int[] a) {
        Set<Integer> count = new HashSet<Integer>();
        int n = a.length;
        int expectedSum = (n * (n + 1)) / 2;
        int actualSum = 0;

        for (int i = 0; i < a.length; i++) {
            if (!count.add(a[i])) {
                return 0;
            }
            actualSum += a[i];
        }

        if (expectedSum == actualSum) {
            return 1;
        } else {
            return 0;
        }
    }

}
