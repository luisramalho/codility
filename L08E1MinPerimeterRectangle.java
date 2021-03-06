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
 * Find the minimal perimeter of any rectangle whose area equals N.
 *
 * @author luisramalho
 */
public class L08E1MinPerimeterRectangle {

    /**
     * Computes the minimal perimeter of any rectangle whose area is exactly
     * equal to n.
     *
     * @param n integer representing the area of some rectangle. N is an integer
     * within the range [1..1,000,000,000].
     * @return the minimal perimeter of any rectangle whose area is exactly
     * equal to n.
     */
    public int solution(int n) {
        int minPerimeter = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                minPerimeter = Math.min(minPerimeter, 2 * (i + (n / i)));
            }
        }
        return minPerimeter;
    }

}
