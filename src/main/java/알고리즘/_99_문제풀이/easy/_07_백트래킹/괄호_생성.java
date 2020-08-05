package 알고리즘._99_문제풀이.easy._07_백트래킹;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 괄호_생성 {
    /* -----------------------------------------------------------------------------
        22. Generate Parentheses

        Given n pairs of parentheses,
        write a function to generate all combinations of well-formed parentheses.

        For example, given n = 3, a solution set is:

        [
          "((()))",
          "(()())",
          "(())()",
          "()(())",
          "()()()"
        ]
    ----------------------------------------------------------------------------------*/
    // backtracking (~ recursion + termination check)
    public List<String> generateParentheses(int n) {
        List<String> ret = new ArrayList<>();
        process(n, 0, 0,  ret, "");
        return ret;
    }

    // numClosed > numOpen -> invalid
    public void process(int n, int numOpen, int numClosed, List<String> ret, String str) {
        // termination check
        if(numOpen == n && numClosed == n) {
            ret.add(str);
            return;
        }

        // recurse next
        if(numOpen < n) {
            process(n, numOpen + 1, numClosed, ret, str + "("); // add open bracket
        }
        if(numOpen > numClosed) {
            process(n, numOpen, numClosed + 1, ret, str + ")"); // add close bracket
        }
    }

    @Test
    public void generateParenthesesTest() {
        List<String> strings = generateParentheses(3);
        System.out.println(Arrays.asList(strings).toString());
    }

}
