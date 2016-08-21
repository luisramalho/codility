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
 * Determine whether a given string of parentheses is properly nested.
 *
 * @author luisramalho
 *
 */
public final class L05E1Brackets {

    /**
     * L016Brackets is non-instantiable.
     */
    private L05E1Brackets() {

    }

    /**
     * Main method.
     *
     * @param args
     *            Arguments.
     */
    public static void main(final String[] args) {
        System.out.println(solution("{[()()]}")); // Properly nested
        System.out.println(solution("([)()]")); // Not properly nested
        System.out.println(solution("((")); // Negative match
    }

    /**
     * Determines whether a given string of parentheses is properly nested.
     *
     * @param s
     *            string consisting of N characters. N is an integer within the
     *            range [0..200,000]; string S consists only of the following
     *            characters: "(", "{", "[", "]", "}" and/or ")".
     * @return <code>1</code> if s is properly nested; <code>0</code> otherwise.
     */
    public static int solution(final String s) {

        // If it's empty then it's nested properly.
        if (s.length() == 0) {
            return 1;
        }

        // If not even then it can't be nested properly.
        if (s.length() % 2 != 0) {
            return 0;
        }

        char c;
        Stack<Character> parentheses = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                parentheses.add(c);
            } else { // Closing bracket
                if (parentheses.empty() || !match(c, parentheses.pop())) {
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

    /**
     * Checks if the closing bracket matches with the candidate.
     *
     * @param c
     *            Closing bracket character.
     * @param candidate
     *            Candidate of a possible opening bracket.
     * @return <code>true</code> if they match; <code>false</code> otherwise;
     */
    private static boolean match(final char c, final char candidate) {
        switch (c) {
        case ')':
            return candidate == '(';
        case '}':
            return candidate == '{';
        case ']':
            return candidate == '[';
        default:
            return false;
        }
    }
}
