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

import java.util.Arrays;

/**
 * Find the index S such that the leaders of the sequences A[0], A[1], ..., A[S]
 * and A[S + 1], A[S + 2], ..., A[N - 1] are the same.
 *
 * @author luisramalho
 *
 */
public final class L06E2EquiLeader {

    /**
     * L6E2EquiLeader is non-instantiable.
     */
    private L06E2EquiLeader() {

    }

    /**
     * Main method.
     *
     * @param args
     *            Arguments.
     */
    public static void main(final String[] args) {
        int[] a = { 4, 3, 4, 4, 4, 2 };
        System.out.println(solution(a));

        int[] b = { 1, 1 };
        System.out.println(solution(b));
    }

    /**
     * Computes the the number of equi leaders.
     *
     * @param a
     *            non-empty zero-indexed array consisting of N integers. N is an
     *            integer within the range [1..100,000]; each element of array A
     *            is an integer within the range
     *            [−1,000,000,000..1,000,000,000].
     * @return the number of equi leaders.
     */
    public static int solution(final int[] a) {
        int n = a.length;
        int equiLeaders = 0;
        int[] leadersPositions = new int[n];

        if (n == 1) {
            return 0;
        }

        int[] unsorted = a.clone();

        Arrays.sort(a);

        int candidate = a[n / 2];
        int leader = -1;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] == candidate) {
                count++;
            }
        }

        if (count > n / 2) {
            leader = candidate;
        }

        if (unsorted[0] == leader) {
            leadersPositions[0] = 1;
        }

        for (int i = 1; i < n; i++) {
            leadersPositions[i] = leadersPositions[i - 1];
            if (unsorted[i] == leader) {
                leadersPositions[i]++;
            }
        }

        int left, right;

        for (int i = 1; i < n; i++) {
            left = leadersPositions[i - 1];
            right = leadersPositions[n - 1] - leadersPositions[i - 1];

            if (left > i / 2 && right > (n - i) / 2) {
                equiLeaders++;
            }
        }

        return equiLeaders;
    }
}
