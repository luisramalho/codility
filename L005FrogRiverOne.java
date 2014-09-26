import java.util.HashSet;
import java.util.Set;

/**
 * Finds the earliest time when a frog can jump to the other side of a river.
 * 
 * @author luisramalho
 * 
 */
public final class L005FrogRiverOne {

    /**
     * Position to which the frog wants to get.
     */
    private static final int X = 5;

    /**
     * N integers representing the falling leaves.
     */
    private static final int[] A = { 1, 3, 1, 4, 2, 3, 5, 4 };

    /**
     * Private constructor.
     */
    private L005FrogRiverOne() {
    }

    /**
     * Main method.
     * 
     * @param args
     *            Arguments.
     */
    public static void main(final String[] args) {
        System.out.println(solution(X, A));
    }

    /**
     * Earliest time when the frog can jump to the other side of the river. The
     * frog can cross only when leaves appear at every position across the river
     * from 1 to X.
     * 
     * @param x
     *            Final position.
     * @param a
     *            Non-empty zero-indexed array, consisting of N integers
     *            representing falling leaves. A[K] represents the position
     *            where one leaf falls at time K, measured in minutes.
     * @return the earliest time when the frog can jump to the other side of the
     *         river; <code>−1</code> If the frog is never able to jump to the
     *         other side of the river.
     */
    public static int solution(final int x, final int[] a) {
        Set<Integer> leaves = new HashSet<Integer>();
        for (int i = 1; i <= x; i++) {
            leaves.add(i);
        }

        Set<Integer> s = new HashSet<Integer>();
        for (int i = 0; i < a.length; i++) {
            s.add(a[i]);
            if (s.size() < x) {
                continue;
            } else if (s.containsAll(leaves)) {
                return i;
            }
        }
        return -1;
    }

}
