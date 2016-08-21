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
 * Compute number of inversion in an array.
 *
 * @author luisramalho
 */
public class L99E4ArrayInversionCount {

    /**
     * Computes the number of inversions.
     *
     * An inversion is a pair of indexes (P, Q) such that P < Q and A[Q] < A[P].
     *
     * @param a zero-indexed array, consisting of N integers. N is an integer
     * within the range [0..100,000]; each element of array A is an integer
     * within the range [−2,147,483,648..2,147,483,647].
     * @return the number of inversions in a; <code>-1</code> if it exceeds
     * 1,000,000,000.
     */
    public int solution(int[] a) {
        int n = a.length;
        if (n < 2) {
            return 0;
        }

        int mid = n / 2;

        int[] left = Arrays.copyOfRange(a, 0, mid);
        int[] right = Arrays.copyOfRange(a, mid, n);

        return solution(left) + solution(right) + merge(left, right, a);
    }

    /**
     * Computes the number of inversions. Basically, when we have an element in
     * the right array and it's going to be merged in the final array it means
     * that all the elements that have not yet been merged from the left array
     * are larger than the element removed from the right array. Hence they are
     * inversions.
     *
     * @param left the left array
     * @param right the right array
     * @param a the final sorted array
     * @return the number of inversions
     */
    private int merge(int[] left, int[] right, int[] a) {
        int nL = left.length;
        int nR = right.length;
        int i = 0;
        int j = 0;
        int k = 0;
        int inversions = 0;
        while (i < nL && j < nR) {
            if (left[i] <= right[j]) {
                a[k] = left[i];
                i++;
            } else {
                a[k] = right[j];
                inversions += nL - i;
                j++;
            }
            k++;
        }
        while (i < nL) {
            a[k] = left[i];
            i++;
            k++;
        }
        while (j < nR) {
            a[k] = right[j];
            j++;
            k++;
        }
        return inversions;
    }
}
