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
 * Counts minimal number of jumps from position X to Y.
 *
 * @author luisramalho
 *
 */
public final class L01E1FrogJmp {

    /**
     * Private constructor.
     */
    private L01E1FrogJmp() {

    }

    /**
     * Current position.
     */
    public static final int X = 10;

    /**
     * Final position.
     */
    public static final int Y = 85;

    /**
     * Number of jumps.
     */
    public static final int D = 30;

    /**
     * Main method.
     *
     * @param args
     *            arguments
     */

    public static void main(final String[] args) {
        System.out.println(solution(X, Y, D));
    }

    /**
     * Counts the minimal number of jumps from position X to Y.
     *
     * @param x
     *            current position
     * @param y
     *            final position
     * @param d
     *            jump distance
     * @return number of jumps
     */
    private static int solution(final int x, final int y, final int d) {
        final int distance = y - x;
        final int jumps = distance / d;

        if (distance % D == 0) {
            return jumps;
        } else {
            return jumps + 1;
        }
    }

}
