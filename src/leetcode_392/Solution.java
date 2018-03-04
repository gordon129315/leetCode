/*
https://leetcode.com/problems/is-subsequence/description/
392. Is Subsequence
 */


package leetcode_392;

import java.util.LinkedList;


public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
        String s = "agcb", t = "ahbgdc";
        System.out.println(isSubsequence(s, t));

    }

    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.equals("")) {
            return true;
        }
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == list.getFirst()) {
                list.removeFirst();
                if (list.isEmpty()) {
                    return true;
                }
            }
        }
        return list.isEmpty();
    }
}
