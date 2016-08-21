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

import java.util.Arrays;

/**
 * Finds the minimal nucleotide from a range of sequence DNA.
 *
 * @author luisramalho
 *
 */
public final class L03E2GenomicRangeQuery {

    /**
     * Number of nucleotides (A, C, G and T).
     */
    static final int NUMBER_OF_NUCLEOTIDES = 4;

    /**
     * Private constructor.
     */
    private L03E2GenomicRangeQuery() {

    }

    /**
     * Main method.
     *
     * @param args
     *            Arguments.
     */
    public static void main(final String[] args) {
        int[] p = { 2, 5, 0 };
        int[] q = { 4, 5, 6 };
        String s = "CAGCCTA";
        System.out.println(Arrays.toString(solution(s, p, q)));
    }

    /**
     * Finds the minimal nucleotide from a range of sequence DNA.
     *
     * @param s
     *            Non-empty zero-indexed string, consisting of N characters.
     * @param p
     *            Non-empty zero-indexed array, consisting of M integers.
     * @param q
     *            Non-empty zero-indexed array, consisting of M integers.
     * @return an array consisting of M integers specifying the consecutive
     *         answers to all queries.
     */
    public static int[] solution(final String s, final int[] p, final int[] q) {

        // Mark the position of each element
        int[][] a = new int[NUMBER_OF_NUCLEOTIDES][s.length()];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
            case 'A':
                a[0][i]++;
                break;
            case 'C':
                a[1][i]++;
                break;
            case 'G':
                a[2][i]++;
                break;
            case 'T':
                a[3][i]++;
                break;
            default:
                break;
            }
        }

        // Compute prefix sum
        int[][] prefixSum = new int[NUMBER_OF_NUCLEOTIDES][s.length() + 1];
        for (int k = 1; k < s.length() + 1; k++) {
            for (int j = 0; j < NUMBER_OF_NUCLEOTIDES; j++) {
                prefixSum[j][k] = prefixSum[j][k - 1] + a[j][k - 1];
            }
        }

        // Count total
        int[] m = new int[p.length];
        for (int i = 0; i < p.length; i++) {
            int x = p[i];
            int y = q[i];
            for (int j = 0; j < NUMBER_OF_NUCLEOTIDES; j++) {
                if (prefixSum[j][y + 1] - prefixSum[j][x] > 0) {
                    m[i] = j + 1;
                    break;
                }
            }
        }

        return m;
    }
}
