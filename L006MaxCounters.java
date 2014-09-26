/**
 * Calculate the values of counters after applying all alternating operations:
 * increase counter by 1; set value of all counters to current maximum.
 * 
 * @author luisramalho
 * 
 */
public final class L006MaxCounters {

    /**
     * Private constructor.
     */
    private L006MaxCounters() {
    }

    /**
     * Main method.
     * 
     * @param args
     *            Arguments
     */
    public static void main(final String[] args) {
        int n = 5;
        int[] a = { 3, 4, 4, 6, 1, 4, 4 };
        StringBuilder sb = new StringBuilder();
        for (int i : solution(n, a)) {
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(i);
        }
        System.out.printf("[%s]", sb.toString());
    }

    /**
     * Calculate the value of every counter after all operations.
     * 
     * @param n
     *            Number of counters.
     * @param a
     *            Non-empty zero-indexed array of M integers
     * @return A sequence of integers representing the values of the counters.
     */
    public static int[] solution(final int n, final int[] a) {
        int[] sequence = new int[n];
        int max = 0, min = 0;

        for (int k = 0; k < a.length; k++) {
            if (a[k] <= n) { // increase(X)
                if (sequence[a[k] - 1] <= min) {
                    sequence[a[k] - 1] = min;
                }
                max = Math.max(max, ++sequence[a[k] - 1]);
            } else { // max counter
                min = max;
            }
        }

        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] < min) {
                sequence[i] = min;
            }
        }

        return sequence;
    }

}
