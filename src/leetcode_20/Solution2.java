package leetcode_20;

import java.util.Stack;

public class Solution2 {
    public static void main(String[] args) {
        new Solution2().run();
    }

    public void run() {
        String str = "[]{}()({[]})";
        System.out.println(isValid(str));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c)
            {
                case '(' :
                    stack.push(')');
                    break;
                case '{' :
                    stack.push('}');
                    break;
                case '[' :
                    stack.push(']');
                    break;
                default :
                    if (stack.empty() || c != stack.pop()) {
                        return false;
                    }
            }
        }
        return stack.empty();
    }
}
