package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

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
public class ValidParentheses {


    // left ones - keep pushing in stack, right ones should matching top of stack(pop)
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }

        Deque<Character> stack = new ArrayDeque<>();

        char temp;
        char pop;
        for (int i = 0; i < s.length(); i++) {
            temp = s.charAt(i);
            //if left ones
            if (temp == '{' || temp == '(' || temp == '[') {
                stack.push(s.charAt(i)); //TODO another ways is to push one's right side, so that later just do  == for matching
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                pop = stack.pop();
                if (!match(pop, temp)) {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }

    private boolean match(char l, char r) {
        return (l == '{' && r == '}') || (l == '[' && r == ']') || (l == '(' && r == ')');
    }


    public static void main(String[] args) {
        String s = "]";
        System.out.println(new ValidParentheses().isValid(s));
    }
}
