package codility;

/**
 * Find the missing element in a given permutation.
 *
 * @author luisramalho
 *
 */

public final class L003PermMissingElem {

    /**
     * Private constructor.
     */
    private L003PermMissingElem() {
    }

    /**
     * Main method.
     *
     * @param args
     *            Arguments.
     */
    public static void main(final String[] args) {
        int[] ary = { 2, 3, 1, 5 };
        System.out.println(solution(ary));
    }

    /**
     * Finds the missing element in a given permutation.
     *
     * @param a
     *            Array
     * @return The value of the missing element.
     */
    private static int solution(final int[] a) {
        long n = a.length + 1;
        long expectedTotal = (n * (n + 1)) / 2;
        long actualTotal = 0;

        for (int i = 0; i < a.length; i++) {
            actualTotal += a[i];
        }

        int missingElement = (int) (expectedTotal - actualTotal);

        return missingElement;
    }

}
