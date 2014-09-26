package codility;

/**
 * Maximize A[P] * A[Q] * A[R] for any triplet (P, Q, R).
 *
 * @author luisramalho
 *
 */
public final class L014MaxProductOfThree {

    /**
     * L014MaxProductOfThree is non-instantiable.
     */
    private L014MaxProductOfThree() {

    }

    /**
     * Main method.
     *
     * @param args
     *            Arguments.
     */
    public static void main(final String[] args) {
        int[] a = { -3, 1, 2, -2, 5, 6 };
        System.out.println(solution(a));
    }

    /**
     * Maximizes A[P] * A[Q] * A[R] for any triplet (P, Q, R).
     *
     * @param a
     *            Non-empty zero-indexed array consisting of N integers. N is an
     *            integer within the range [3..100,000]; each element of array A
     *            is an integer within the range [−1,000..1,000].
     * @return the value of the maximal product of any triplet.
     */
    public static int solution(final int[] a) {
        int size = a.length;

        // Merge sorts the array
        mergeSort(a, 0, size - 1);

        /*
         * The product of triplet (P, Q, R) equates to A[P] * A[Q] * A[R] (0 ≤ P
         * < Q < R < N).
         * 
         * The product of two negatives will be a positive, so it's crucial to
         * check if there are two negative with a product that is higher than
         * the second and third to last numbers in the array.
         */
        int product = 0;
        int last = size - 1;
        int middle = size - 2;
        int first = size - 3;
        if (a[0] < 0 && a[1] < 0 && a[last] > 0) { // 2 negatives
            product = Math.max(a[0] * a[1], a[first] * a[middle]) * a[last];
        } else {
            product = a[first] * a[middle] * a[last];
        }

        return product;
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
