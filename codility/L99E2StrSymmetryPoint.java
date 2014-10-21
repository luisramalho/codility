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
 * Finds a symmetry point of a string, if any.
 *
 * @author luisramalho
 */
public class L99E2StrSymmetryPoint {

    public int solution(String s) {
        int length = s.length();
        int middle = length / 2;
        
        if (length == 1) {
            return 0;
        }

        if (length % 2 == 0) {
            return -1;
        }

        String left = s.substring(0, middle);
        String right = s.substring(middle + 1, length);
        
        for (int i = middle - 1; i >= 0; i--) {
            if (left.charAt(i) != right.charAt(middle - 1 - i)) {
                return -1;
            }
        }
        
        return length / 2;
    }
}
