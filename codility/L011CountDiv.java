package codility;

/**
 * Computes the number of integers divisible by k in range [a..b].
 *
 * @author luisramalho
 *
 */
public final class L011CountDiv {

    /**
     * Private constructor.
     */
    private L011CountDiv() {

    }

    /**
     * Main method.
     *
     * @param args
     *            Arguments.
     */
    public static void main(final String[] args) {
        int s = solution(6, 11, 2);
        System.out.println(s);
    }

    /**
     * Computes the number of integers divisible by k in range [a..b].
     *
     * { i : a ≤ i ≤ b, i mod k = 0 }
     *
     * @param a
     *            integer within the range [0..2,000,000,000]
     * @param b
     *            integer within the range [0..2,000,000,000]
     * @param k
     *            integer within the range [1..2,000,000,000]
     * @return the number of integers within the range [A..B] that are divisible
     *         by K
     */
    public static int solution(final int a, final int b, final int k) {
        int n = (b / k) - (a / k);
        if (a % k == 0) {
            n++;
        }
        return n;
    }

}
