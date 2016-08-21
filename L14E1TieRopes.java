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
 *
 * @author luisramalho
 */
public class L14E1TieRopes {

    /**
     * Computes the maximum number of ropes of length greater than or equal to K
     * that can be created.
     *
     * @param k an integer within the range [1..1,000,000,000];
     * @param a non-empty zero-indexed array of N integers. N is an integer
     * within the range [1..100,000]; Each element of the array is an integer
     * within the range [1..1,000,000,000].
     * @return the maximum number of ropes.
     */
    public int solution(int k, int[] a) {
        int length = 0;
        int ropes = 0;

        for (int i = 0; i < a.length; i++) {
            length += a[i];

            if (length >= k) {
                length = 0;
                ropes++;
            }
        }

        return ropes;
    }
}
