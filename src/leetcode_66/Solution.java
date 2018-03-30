/*
https://leetcode.com/problems/plus-one/description/
66. Plus One
 */

package leetcode_66;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
        int[] digits = {9};
//        plusOne(digits);
        System.out.println(Arrays.toString(plusOne(digits)));
    }

    public int[] plusOne(int[] digits) {
        int length = digits.length;
        for (int i = length - 1; i >= 0 ; i--) {
            if (digits[i] + 1 != 10) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        digits = new int[length + 1];
        digits[0] = 1;
        return digits;

    }
}
