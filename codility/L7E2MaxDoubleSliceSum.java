package codility;


/**
 * Find the maximal sum of any double slice.
 *
 * @author luisramalho
 *
 */
public final class L7E2MaxDoubleSliceSum {

    /**
     * L7E2MaxDoubleSliceSum is non-instantiable.
     */
    private L7E2MaxDoubleSliceSum() {

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
