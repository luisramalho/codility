package codility;

import java.util.Arrays;

/**
 * Finds the minimal positive integer not occurring in a given sequence.
 *
 * @author luisramalho
 *
 */
public final class L2E4MissingInteger {

    /**
     * Private constructor.
     */

    private L2E4MissingInteger() {
    }

    /**
     * Main method.
     *
     * @param args
     *            Arguments
     */
    public static void main(final String[] args) {
        int[] a = { 1, 3, 6, 4, 1, 2 };
        System.out.println(solution(a));
    }

    /**
     * Finds the minimal positive integer not occurring in a given sequence.
     *
     * @param a
     *            Non-empty zero-indexed array of N integers
     * @return Minimal positive integer that does not occur in A
     */
    public static int solution(final int[] a) {
        int min = 1;
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            if (min == a[i]) {
                min++;
            }
        }
        return min;
    }

}
