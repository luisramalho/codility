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

import java.util.ArrayList;

/**
 * Count the minimum number of jumps required for a frog to get to the other
 * side of a river.
 *
 * @author luisramalho
 */
public class L11E2FibFrog {

    class Position {

        int x;
        int jumps;

        Position(int x, int jumps) {
            this.x = x;
            this.jumps = jumps;
        }
    }

    /**
     * Computes the minimum number of jumps by which the frog can get to the
     * other side of the river.
     *
     * @param a zero-indexed array consisting of N integers. N is an integer
     * within the range [0..100,000]; each element of array A is an integer that
     * can have one of the following values: 0, 1.
     *
     * @return the minimum number of jumps; <code>-1</code> if the frog cannot
     * reach the other side of the river.
     */
    public int solution(int[] a) {
        int n = a.length;
        ArrayList<Integer> fibs = fibonacci(n);
        boolean[] visited = new boolean[n];
        
        ArrayList<Position> positions = new ArrayList<>();
        positions.add(new Position(-1, 0));
        Position currentPosition;
        int nextPosition = 0;
        int nextJump;
        while (true) {
            currentPosition = positions.get(nextPosition);
            nextPosition++;
            for (int f : fibs) {
                nextJump = currentPosition.x + f;
                
                // Final jump
                if (nextJump == n) { 
                    return currentPosition.jumps + 1;
                }
                
                if (nextJump > n || a[nextJump] == 0 || visited[nextJump]) {
                    continue;
                }

                positions.add(new Position(nextJump, currentPosition.jumps + 1));
                visited[nextJump] = true;
            }
            
            // No more positions to check, frog can't get to the other side
            if (nextPosition == positions.size()) {
                return -1;
            }
        }
    }

    /**
     * Computes the Fibonacci sequence upto limit.
     *
     * @param limit largest Fibonacci number
     * @return the Fibonacci sequence upto limit
     */
    public ArrayList<Integer> fibonacci(int limit) {
        ArrayList<Integer> fibs = new ArrayList<>();
        fibs.add(1); // Start fibonacci sequence with 1
        fibs.add(2);
        int i = 1;
        while (fibs.get(i) <= limit) {
            fibs.add(fibs.get(i) + fibs.get(i - 1));
            i++;
        }
        
        // Reverse the Fibonacci sequence
        for (int f = 0, j = fibs.size() - 1; f < j; f++) {
            fibs.add(f, fibs.remove(j));
        }
        return fibs;
    }

}
