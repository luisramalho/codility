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

import java.util.HashSet;
import java.util.Set;

/**
 * Compute number of distinct absolute values of sorted array elements.
 *
 * @author luisramalho
 */
public class L13E1AbsDistinct {

    /**
     * Computes the number of distinct absolute values of sorted array elements.
     *
     * @param a non-empty zero-indexed array consisting of n numbers. N is an
     * integer within the range [1..100,000]; each element of array A is an
     * integer within the range [−2,147,483,648..2,147,483,647]; array is sorted
     * in non-decreasing order.
     * @return absolute distinct count of array a.
     */
    public int solution(int[] a) {
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            s.add(Math.abs(a[i]));
        }
        return s.size();
    }
}
