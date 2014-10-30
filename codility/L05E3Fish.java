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

import java.util.Stack;

/**
 * N voracious fish are moving along a river. Calculate how many fish are alive.
 *
 * @author luisramalho
 */
public class L05E3Fish {

    int upstreamSurvivors = 0;
    Stack<Integer> downstream = new Stack<>();

    /**
     * Computes the number of fish that will stay alive.
     *
     * @param a non-empty zero-indexed array consisting of N integers. N is an
     * integer within the range [1..100,000]; Each element of the array is an
     * integer within the range [0..1,000,000,000]; The elements of A are all
     * distinct.
     * @param b non-empty zero-indexed array consisting of N integers. N is an
     * integer within the range [1..100,000]; Each element of array B is an
     * integer that can have one of the following values: 0, 1;
     * @return the number of fish that will stay alive
     */
    public int solution(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (b[i] == 1) { // downstream
                downstream.add(a[i]);
            } else { // upstream
                fight(a[i]);
            }
        }

        return downstream.size() + upstreamSurvivors;
    }

    /**
     * Computes the result of a fight between two fishes.
     *
     * @param opponent the size of the opponent
     */
    private void fight(int opponent) {
        while (!downstream.isEmpty()) {
            if (downstream.peek() < opponent) {
                downstream.pop(); // eaten
            } else {
                return;
            }
        }
        upstreamSurvivors++;
    }

}
