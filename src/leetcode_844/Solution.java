package leetcode_844;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    private void run() {
        String S = "ab#c";
        String T = "ad#c";

        System.out.println(backspaceCompare(S, T));
    }

    public boolean backspaceCompare(String S, String T) {
        return parseString(S).equals(parseString(T));
    }

    private String parseString(String S) {
        String str = "";
        LinkedList<Character> stack = new LinkedList<>();
        int length = S.length();
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            if (c == '#') {
                if (!stack.isEmpty()) {
                    stack.removeLast();
                }
            }
            else {
                stack.add(c);
            }
        }
        for (Character c : stack) {
            str += c;
        }
        return str;
    }
}
