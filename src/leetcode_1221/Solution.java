//https://leetcode.com/problems/split-a-string-in-balanced-strings/
//1221. Split a String in Balanced Strings

package leetcode_1221;

import java.util.LinkedList;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    private void run() {
        System.out.println(balancedStringSplit("RRLLLLRR"));
    }

    public int balancedStringSplit(String s) {
        if (s.length() < 2) {
            return -1;
        }

        Stack<Character> stack = new Stack<>();
        int count = 0;

        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);

            if (stack.isEmpty()) {
                stack.push(c);
            }
            else {
                if (c == stack.peek()) {
                    stack.push(c);
                }
                else {
                     stack.pop();
                    if (stack.isEmpty()){
                        count ++;
                    }
                }
            }
        }

        return stack.isEmpty()? count : -1;
    }
}
