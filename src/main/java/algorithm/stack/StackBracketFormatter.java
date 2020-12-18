package algorithm.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author traeper
 */
public class StackBracketFormatter {

    public static boolean checkBracketFormat(String s) {
        Map<String, String> map = new HashMap<>();

        char[] chars = s.toCharArray();

        Stack<Character> bracketStack = new Stack<>();

        for (char c : chars) {
            if (c == '{' || c == '(' || c == '[') {
                bracketStack.push(c);
            }
            if (c == '}' || c == ')' || c == ']') {
                char pop = bracketStack.pop();

                if (c == '}' && pop != '{') {
                    return false;
                }
                if (c == ')' && pop != '(') {
                    return false;
                }
                if (c == ']' && pop != '[') {
                    return false;
                }
            }
        }

        return bracketStack.isEmpty();
    }

}
