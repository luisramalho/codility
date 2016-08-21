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
 * Finds the minimal positive integer not occurring in a given sequence.
 *
 * @author luisramalho
 *
 */
public final class L02E4MissingInteger {

    /**
     * Private constructor.
     */

    private L02E4MissingInteger() {
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
