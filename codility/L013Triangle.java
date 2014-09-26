package codility;

/**
 * Determines whether a triangle can be built from a given set of edges.
 *
 * @author luisramalho
 *
 */
public final class L013Triangle {

    /**
     * L013Triangle is non-instantiable.
     */
    private L013Triangle() {

    }

    /**
     * Main method.
     *
     * @param args
     *            Arguments.
     */
    public static void main(final String[] args) {
        int[] a = { 10, 2, 5, 1, 8, 20 };
        System.out.println(solution(a));
    }

    /**
     * A triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N.
     *
     * @param a
     *            zero-indexed array consisting of N integers. N is an integer
     *            within the range [0..1,000,000]; each element of array A is an
     *            integer within the range [−2,147,483,648..2,147,483,647].
     * @return <code>1</code> if there exists a triangular triplet for this
     *         array; <code>0</code> otherwise.
     */
    public static int solution(final int[] a) {
        int size = a.length;

        if (size < 3) {
            return 0;
        }

        // Merge sorts the array
        mergeSort(a, 0, size - 1);

        /*
         * A triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:
         * 
         * A[P] + A[Q] > A[R], A[Q] + A[R] > A[P], A[R] + A[P] > A[Q].
         * 
         * The conversion to long is done so that it prevents against integer
         * overflow, since Integer.MAX_VALUE is the highest possible value of N.
         */

        for (int i = 0; i < size - 2; i++) {
            long ap = a[i];
            long aq = a[i + 1];
            long ar = a[i + 2];
            if (ap + aq > ar && aq + ar > ap && ar + ap > aq) {
                return 1;
            }
        }

        return 0;
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
