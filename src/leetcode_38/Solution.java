/*
https://leetcode.com/problems/count-and-say/description/
38. Count and Say
 */

package leetcode_38;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
        System.out.println(countAndSay(5));
    }

    public String countAndSay(int n) {
        if (n <= 0 ) {
            return "1";
        }

        String str = "1";
        for (int i = 1; i < n; i++) {
            str = generate(str);
        }
        return str;
    }

    public String generate(String str) {
        int count = 1;
        String newStr = "";
        char c = str.charAt(0);
        for (int i = 0; i < str.length() - 1; i++) {
            if (c == str.charAt(i + 1)) {
                count++;
            }
            else {
                newStr += String.valueOf(count) + c;
                count = 1;
                c = str.charAt(i + 1);
            }
        }

        newStr += String.valueOf(count) + c;

        return newStr;
    }
}
