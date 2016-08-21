/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Luís Ramalho
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

/**
 * Calculate the values of counters after applying all alternating operations:
 * increase counter by 1; set value of all counters to current maximum.
 *
 * @author luisramalho
 *
 */
public final class L02E3MaxCounters {

    /**
     * Private constructor.
     */
    private L02E3MaxCounters() {
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
