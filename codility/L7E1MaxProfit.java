package codility;

/**
 * Given a log of stock prices compute the maximum possible earning.
 *
 * @author luisramalho
 *
 */
public final class L7E1MaxProfit {

    /**
     * L7E1MaxProfit is non-instantiable.
     */
    private L7E1MaxProfit() {

    }

    /**
     * Main method.
     *
     * @param args
     *            Arguments.
     */
    public static void main(final String[] args) {
        int[] a = { 23171, 21011, 21123, 21366, 21013, 21367 };
        System.out.println(solution(a)); // 356
    }

    /**
     *
     * @param a
     *            Zero-indexed array consisting of N integers. N is an integer
     *            within the range [0..400,000]; each element of array A is an
     *            integer within the range [0..200,000].
     * @return the maximum possible profit from one transaction during this
     *         period; <code>0</code> if it was impossible to gain any profit.
     */
    public static int solution(final int[] a) {
        int maxProfit = 0;
        int maxSlice = 0;

        for (int i = 1; i < a.length; i++) {
            maxProfit = Math.max(0, maxProfit + (a[i] - a[i - 1]));
            maxSlice = Math.max(maxSlice, maxProfit);
        }

        if (maxSlice < 0) {
            maxSlice = 0;
        }

        return maxSlice;
    }

}
