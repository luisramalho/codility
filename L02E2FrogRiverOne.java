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
 * Finds the earliest time when a frog can jump to the other side of a river.
 *
 * @author luisramalho
 *
 */
public final class L02E2FrogRiverOne {

    /**
     * Position to which the frog wants to get.
     */
    private static final int X = 5;

    /**
     * N integers representing the falling leaves.
     */
    private static final int[] A = { 1, 3, 1, 4, 2, 3, 5, 4 };

    /**
     * Private constructor.
     */
    private L02E2FrogRiverOne() {
    }

    /**
     * Main method.
     *
     * @param args
     *            Arguments.
     */
    public static void main(final String[] args) {
        System.out.println(solution(X, A));
    }

    /**
     * Earliest time when the frog can jump to the other side of the river. The
     * frog can cross only when leaves appear at every position across the river
     * from 1 to X.
     *
     * @param x
     *            Final position.
     * @param a
     *            Non-empty zero-indexed array, consisting of N integers
     *            representing falling leaves. A[K] represents the position
     *            where one leaf falls at time K, measured in minutes.
     * @return the earliest time when the frog can jump to the other side of the
     *         river; <code>−1</code> If the frog is never able to jump to the
     *         other side of the river.
     */
    public static int solution(final int x, final int[] a) {
        Set<Integer> leaves = new HashSet<Integer>();
        for (int i = 1; i <= x; i++) {
            leaves.add(i);
        }

        Set<Integer> s = new HashSet<Integer>();
        for (int i = 0; i < a.length; i++) {
            s.add(a[i]);
            if (s.size() < x) {
                continue;
            } else if (s.containsAll(leaves)) {
                return i;
            }
        }
        return -1;
    }

}
