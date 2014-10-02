package codility;

import java.util.Stack;

/**
 * Determine whether a given string of parentheses is properly nested.
 *
 * @author luisramalho
 *
 */
public final class L5E1Brackets {

    /**
     * L016Brackets is non-instantiable.
     */
    private L5E1Brackets() {

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
