/*
 * The MIT License
 *
 * Copyright 2014 luisramalho.
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
package codility;

/**
 * Find the maximum sum of a compact subsequence of array elements.
 * 
 * @author luisramalho
 */
public class L7E3MaxSliceSum {
    
    public L7E3MaxSliceSum() {}
    
    /**
     * Finds the maximum sum of a compact subsequence of array elements.
     * @param a non-empty zero-indexed array consisting of N integers is given.
     * N is an integer within the range [1..1,000,000]; each element of array a 
     * is an integer within the range [−1,000,000..1,000,000];
     * @return  the maximum sum of any slice of a.
     */
    public int solution(int[] a) {
        int n = a.length;

        int maxEnding = a[0];
        int maxSlice = maxEnding;
        
        for (int i = 1; i < n; i++) {
            maxEnding = Math.max(a[i], maxEnding + a[i]);
            maxSlice = Math.max(maxSlice, maxEnding);
        }
        
        return maxSlice;
    }
}
