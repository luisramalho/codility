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

import java.util.ArrayList;

/**
 * Divide an array into the maximum number of same((-))sized blocks, each of
 * which should contain an index P such that A[P - 1] < A[P] > A[P + 1].
 *
 * @author luisramalho
 */
public class L08E3Peaks {

    /**
     * Computes the maximum number of blocks into which A can be divided.
     *
     * @param a non-empty zero-indexed array consisting of N integers.
     * @return the maximum number of blocks into which A can be divided.
     */
    public int solution(int[] a) {
        ArrayList<Integer> peaksIndices = peaksIndices(a);
        
        int blocks;
        int peaksFound;
        int n = a.length;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                peaksFound = 0;
                blocks = n / i;
                for (Integer peakIndex : peaksIndices) {
                    if (peakIndex / i == peaksFound) {
                        peaksFound++;
                    }
                }
                if (peaksFound == blocks) {
                    return blocks;
                }
            }
        }
        return 0;
    }

    /**
     * Computes the peaks indices of a.
     *
     * @param a non-empty zero-indexed array consisting of N integers.
     * @return the peaks indices of array a.
     */
    private static ArrayList<Integer> peaksIndices(int[] a) {
        ArrayList<Integer> peaks = new ArrayList<>();
        for (int p = 1; p < a.length - 1; p++) {
            if (a[p - 1] < a[p] && a[p] > a[p + 1]) {
                peaks.add(p);
            }
        }
        return peaks;
    }
}
