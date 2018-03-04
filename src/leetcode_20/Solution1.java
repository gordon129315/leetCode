/*
https://leetcode.com/problems/valid-parentheses/description/
20. Valid Parentheses
 */

package leetcode_20;

import java.util.LinkedList;

public class Solution1 {
    public static void main(String[] args) {
        new Solution1().run();
    }

    public void run() {
        String str = "{}";
        System.out.println(check(str));
    }

    public boolean check (String str){
        if (str == null) {
            return false;
        }

        if (str.equals("")) {
            return true;
        }

        LinkedList<Character> list = new LinkedList<>();
        char ch = ' ';
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            switch (ch) {
                case '(':
                    list.add(')');
                    break;
                case '{':
                    list.add('}');
                    break;
                case '[':
                    list.add(']');
                    break;
                default:
                    if (list.isEmpty()) {
                        return false;
                    }
                    else if (list.getLast() == ch) {
                        list.removeLast();
                    }
                    else if (list.getLast() != ch) {
                        return false;
                    }
                    break;
            }
        }
        return list.isEmpty();
    }
}
