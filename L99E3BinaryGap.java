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
 * Find longest sequence of zeros in binary representation of an integer.
 *
 * @author luisramalho
 */
public class L99E3BinaryGap {

    public int solution(int n) {
        String binary = Integer.toBinaryString(n);
        int binaryGap = 0;
        int binaryGapCandidate = 0;

        int i = 0;
        while (i < binary.length() && binary.charAt(i) != '1') {
            i++;
        }

        // Starts at the first 1, ends second to last
        while (i < binary.length() - 1) {
            if (binary.charAt(i) == '0') {
                binaryGapCandidate++;
            } else {
                binaryGap = Math.max(binaryGap, binaryGapCandidate);
                binaryGapCandidate = 0;
            }
            i++;
        }

        // Last digit
        if (binary.charAt(i) == '0') {
            return binaryGap;
        } else {
            return Math.max(binaryGap, binaryGapCandidate);
        }
    }
}
