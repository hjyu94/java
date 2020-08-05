package 알고리즘._99_문제풀이.easy._02_스택_큐;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import 알고리즘._02_스택_큐.Stack;

import static org.junit.Assert.assertEquals;

public class 괄호_쌍_맞추기 {
    /*
        20. Valid Parentheses
        (https://leetcode.com/problems/valid-parentheses/description/)

        Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
        determine if the input string is valid.

        An input string is valid if:

        Open brackets must be closed by the same type of brackets.
        Open brackets must be closed in the correct order.
        Note that an empty string is also considered valid.

        Example 1:
            Input: "()"
            Output: true

        Example 2:
            Input: "()[]{}"
            Output: true

        Example 3:
            Input: "(]"
            Output: false

        Example 4:
            Input: "([)]"
            Output: false

        Example 5:
            Input: "{[]}"
            Output: true
    */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if(c == ')') {
                    if(!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
                if(c == '}') {
                    if(!stack.isEmpty() && stack.peek() == '{') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
                if(c == ']') {
                    if(!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    @ParameterizedTest
    @ValueSource(strings = {"()", "()[]{}", "{[]}"})
    public void isValidTest_true(String input) {
        assertEquals(isValid(input), true);
    }

    @ParameterizedTest
    @ValueSource(strings = {"(]", "([)]", "[", "]"})
    public void isValidTest_false(String input) {
        assertEquals(isValid(input), false);
    }
}
