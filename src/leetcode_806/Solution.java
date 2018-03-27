/*
https://leetcode.com/contest/weekly-contest-77/problems/number-of-lines-to-write-string/
806. Number of Lines To Write String
 */

package leetcode_806;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
        int[] widths = {4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        String S = "bbbcccdddaaa";
//        String S = "";
        System.out.println(Arrays.toString(numberOfLines(widths, S)));
    }

    public int[] numberOfLines(int[] widths, String S) {
        if (S.length() == 0) {
            return new int[]{0, 0};
        }

        int[] result = {1, 0};

        for (int i = 0; i < S.length(); i++) {
            int unit = widths[S.charAt(i) - 'a'];
            if (result[1] + unit <= 100) {
                result[1] += unit;
            }
            else {
                result[0] ++;
                result[1] = 0;
                result[1] += unit;
            }
        }

        return result;
    }
}
