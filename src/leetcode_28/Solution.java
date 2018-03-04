/*
https://leetcode.com/problems/implement-strstr/description/
28. Implement strStr()
 */


package leetcode_28;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
//        String haystack = "mississippi", needle = "issipi";
        String haystack = "pppppppppi", needle = "pi";
        System.out.println(strStr_2(haystack, needle));
    }

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        if (needle.equals("")) {
            return 0;
        }

        char[] hay = haystack.toCharArray();
        char[] nee = needle.toCharArray();
        int j = 0;                                   // index for needle
        int res = 0;

        for (int i = 0; i < hay.length; i++) {
            if (hay[i] == nee[j]) {
                if (j == 0) {
                    res = i;
                }
                j++;
                if (j == nee.length) {
                    return res;
                }
            }
            else {
                if (j != 0) {
                    i = res;
                    j = 0;
                }

            }
        }
        return -1;
    }



    public int strStr_1(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }
        if (needle.equals("")) {
            return 0;
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            for (int j = 0; j < needle.length() && haystack.charAt(i + j) == needle.charAt(j); j++) {
                if (j == needle.length() - 1) {
                    return i;
                }
            }
        }

        return -1;
    }

    public int strStr_2(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }
        if (needle.equals("")) {
            return 0;
        }

        int gap = haystack.length() - needle.length();
        for (int i = 0; i <= gap; i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
