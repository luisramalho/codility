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

import java.util.Stack;

/**
 * Determine whether given string of parentheses is properly nested.
 *
 * @author luisramalho
 *
 */
public final class L05E2Nesting {

    /**
     * L017Nesting is non-instantiable.
     */
    private L05E2Nesting() {

    }

    /**
     * Main method.
     *
     * @param args
     *            Arguments.
     */
    public static void main(final String[] args) {
        System.out.println(solution("(()(())())"));
        System.out.println(solution("())"));
    }

    /**
     * Determines whether given string of parentheses is properly nested.
     *
     * @param s
     *            string consisting of N characters.
     * @return <code>1</code> if string s is properly nested; <code>0</code>
     *         otherwise.
     */
    public static int solution(final String s) {
        if (s.length() == 0) {
            return 1;
        }

        if (s.length() % 2 != 0) {
            return 0;
        }

        char c;
        Stack<Character> parentheses = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == '(') {
                parentheses.add(c);
            } else { // Closing bracket
                if (parentheses.empty() || parentheses.pop() != '(') {
                    return 0;
                }
            }
        }

        if (parentheses.empty()) {
            return 1;
        } else {
            return 0;
        }

    }

}
