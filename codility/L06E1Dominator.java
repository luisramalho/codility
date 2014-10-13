package codility;

import java.util.Arrays;

/**
 * Find an index of an array such that its value occurs at more than half of
 * indices in the array.
 *
 * @author luisramalho
 *
 */
public final class L06E1Dominator {

    /**
     * L6E1Dominator is non-instantiable.
     */
    private L06E1Dominator() {

    }

    /**
     * Main method.
     *
     * @param args
     *            Arguments.
     */
    public static void main(final String[] args) {
        int[] a = { 3, 4, 3, 2, 3, -1, 3, 3 };
        System.out.println(solution(a));
    }

    /**
     * Finds an index of an array such that its value occurs at more than half
     * of indices in the array.
     *
     * @param a
     *            zero-indexed array consisting of N integers.
     * @return index of any element of array a in which the dominator of a
     *         occurs. The function should return <code>−1</code> if array a
     *         does not have a dominator. N is an integer within the range
     *         [0..100,000]; each element of array A is an integer within the
     *         range [−2,147,483,648..2,147,483,647].
     */
    private static int solution(final int[] a) {
        int n = a.length;

        if (n == 0) {
            return -1;
        }

        int[] unsorted = a.clone();
        Arrays.sort(a);
        int candidate = a[n / 2];
        int index = -1;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (unsorted[i] == candidate) {
                index = i;
                count++;
            }
        }
        if (count > n / 2) {
            return index;
        } else {
            return -1;
        }
    }
}
