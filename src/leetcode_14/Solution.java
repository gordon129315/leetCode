/*
https://leetcode.com/problems/longest-common-prefix/description/
14. Longest Common Prefix
 */

package leetcode_14;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
        String[] strs = {"abc","abd","abg"};
//        String str = "987654321";
//        System.out.println(str.indexOf(""));
//        System.out.println("str:" + str.substring(0,1) + "|");
//        System.out.println();

        System.out.println(longestCommonPrefix(strs));

    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs == null) {
            return "";
        }

        String pre = strs[0];
        for (int i = 0; i < strs.length; i++) {
            while (strs[i].indexOf(pre) != 0) {
                pre = pre.substring(0, pre.length() - 1);
            }

        }

        return pre;
    }

}
