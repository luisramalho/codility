package codility;


/**
 * Compute intersections between sequence of discs.
 *
 * @author luisramalho
 *
 */
public final class L4E4NumberOfDiscIntersections {

    /**
     * L015NumberOfDiscIntersections is non-instantiable.
     */
    private L4E4NumberOfDiscIntersections() {

    }

    /**
     * Main method.
     *
     * @param args
     *            Arguments.
     */
    public static void main(final String[] args) {
        int[] a = { 1, 5, 2, 1, 4, 0 };
        System.out.println(solution(a));
    }

    /**
     * Computes intersections between sequence of discs.
     *
     * @param a
     *            array of N integers; N is an integer within the range
     *            [0..100,000]; each element of the array is an integer within
     *            the range [0..2147483647].
     * @return the number of pairs of intersecting discs.
     */
    public static int solution(final int[] a) {
        int intersectingPairs = 0;

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (j - i <= a[i] + a[j]) {
                    intersectingPairs++;
                }
            }
        }

        if (intersectingPairs > 10_000_000) {
            return -1;
        }
        return intersectingPairs;
    }

}
