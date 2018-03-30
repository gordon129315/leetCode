/*
https://leetcode.com/problems/length-of-last-word/description/
58. Length of Last Word
 */


package leetcode_58;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
        String s = "Hello World";
        System.out.println(lengthOfLastWord(s));
    }

    public int lengthOfLastWord(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int count = 0;
        s = s.trim();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                count = 0;
            }
            else {
                count++;
            }
        }


        return count;
    }
}
