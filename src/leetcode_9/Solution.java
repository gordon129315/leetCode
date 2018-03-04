/*
https://leetcode.com/problems/palindrome-number/description/
9. Palindrome Number
 */

package leetcode_9;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
        System.out.println(isPalindrome(123321));
        System.out.println(isPalindrome_1(12321));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int temp = x;
        int value = 0;
        while (x != 0) {
            value = value * 10 + x % 10;
            x /= 10;
        }

        System.out.println(value);

        return temp == value;
    }



    public boolean isPalindrome_1(int x) {
        if (x < 0) {
            return false;
        }

        String str_value = String.valueOf(x);
        StringBuilder sb_reverse_integer = new StringBuilder();

        for (int i = str_value.length() - 1; i >= 0 ; i--) {
            sb_reverse_integer.append(str_value.charAt(i));
        }

        String str_reverse_integer = sb_reverse_integer.toString();

        return str_value.equals(str_reverse_integer);
    }
}
