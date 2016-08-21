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
 * Counts the number of passing cars on the road.
 *
 * @author luisramalho
 *
 */
public final class L03E1PassingCars {

    /**
     * Private constructor.
     */
    private L03E1PassingCars() {
    }

    /**
     * Maximum number of passing cars.
     */
    static final int LIMIT = 1_000_000_000;

    /**
     * Main method.
     *
     * @param args
     *            Arguments.
     */
    public static void main(final String[] args) {
        int[] a = { 0, 1, 0, 1, 1 };
        System.out.println(solution(a));
    }

    /**
     * Counts passing cars. A pair of cars (P, Q), where 0 ≤ P < Q < N, is
     * passing when P is traveling to the east and Q is traveling to the west.
     *
     * @param a
     *            Non-empty zero-indexed array, consisting of N integers.
     *            Contains only 0s and/or 1s. <code>0</code> represents a car
     *            traveling east, <code>1</code> represents a car traveling
     *            west.
     * @return the number of passing cars; <code>−1</code> if the number of
     *         passing cars exceeds 1,000,000,000.
     */
    public static int solution(final int[] a) {
        int passingCars = 0;
        int carsTravelingEast = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                carsTravelingEast++;
            } else {
                passingCars += carsTravelingEast;
            }
            if (passingCars > LIMIT) {
                return -1;
            }
        }
        return passingCars;
    }
}
