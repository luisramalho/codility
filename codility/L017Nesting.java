package codility;

import java.util.Stack;

/**
 * Determine whether given string of parentheses is properly nested.
 *
 * @author luisramalho
 *
 */
public final class L017Nesting {

    /**
     * L017Nesting is non-instantiable.
     */
    private L017Nesting() {

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
