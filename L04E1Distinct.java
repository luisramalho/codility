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
 * Computes the number of distinct values in an array.
 *
 * @author luisramalho
 *
 */
public final class L04E1Distinct {

    /**
     * Private constructor.
     */
    private L04E1Distinct() {

    }

    /**
     * Main method.
     *
     * @param args
     *            Arguments.
     */
    public static void main(final String[] args) {
        int[] a = { 2, 1, 1, 2, 3, 1 };
        System.out.println(solution(a));
    }

    /**
     * Computes the number of distinct values in an array.
     *
     * @param a
     *            zero-indexed array consisting of N integers. N is an integer
     *            within the range [0..100,000]; each element is an integer
     *            within the range [−1,000,000..1,000,000].
     * @return number of distinct values in array a.
     */
    public static int solution(final int[] a) {
        // Merge sorts the array
        mergeSort(a, 0, a.length - 1);

        // Counts the elements that are unique
        int count = 0;
        int previous = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (previous != a[i]) {
                count++;
            }
            previous = a[i];
        }
        return count;
    }

    /**
     * Implementation of the merge sort based on pseudo code from CLRS.
     *
     * @param a
     *            array to be sorted.
     * @param left
     *            start index of unsorted array.
     * @param right
     *            end index of unsorted array.
     */
    private static void mergeSort(final int[] a, final int left, final int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(a, left, middle);
            mergeSort(a, middle + 1, right);
            merge(a, left, middle, right);
        }
    }

    /**
     * Implementation of the merge sort based on pseudo code from CLRS.
     *
     * @param a
     *            array to be sorted.
     * @param left
     *            start index of the 1st (left) sorted array.
     * @param middle
     *            end index of the 1st (left) sorted array.
     * @param right
     *            end index of the 2nd (right) sorted array.
     */
    private static void merge(final int[] a, final int left, final int middle,
            final int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] l = new int[n1 + 1];
        int[] r = new int[n2 + 1];

        for (int i = 0; i < n1; i++) {
            l[i] = a[left + i];
        }

        for (int j = 0; j < n2; j++) {
            r[j] = a[middle + j + 1];
        }

        l[n1] = Integer.MAX_VALUE;
        r[n2] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;

        for (int k = left; k <= right; k++) {
            if (l[i] <= r[j]) {
                a[k] = l[i];
                i++;
            } else {
                a[k] = r[j];
                j++;
            }
        }
    }
}
