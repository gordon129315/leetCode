
/*
https://leetcode.com/problems/swap-adjacent-in-lr-string/description/
777. Swap Adjacent in LR String
 */
package leetcode_777;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
        String start = "RXXLRXRXL", end = "XRLXXRRLX";
        System.out.println(canTransform(start, end));

    }

    public boolean canTransform(String start, String end) {
        if (!start.replace("X", "").equals(end.replace("X", ""))) {
            return false;
        }

        int p1 = 0;
        int p2 = 0;

        while (p1 < start.length() && p2 < end.length()) {
            //looking for next non-X position
            while (p1 < start.length() && start.charAt(p1) == 'X') {
                p1 ++;
            }
            while (p2 < end.length() && end.charAt(p2) == 'X') {
                p2 ++;
            }

            if (p1 == start.length() && p2 == end.length()) {
                return true;
            }
            else if (p1 == start.length() ^ p2 == end.length()) {
                return false;
            }

            if (start.charAt(p1) == 'L' && p1 < p2) {
                return false;
            }
            else if (start.charAt(p1) == 'R' && p1 > p2) {
                return false;
            }
            p1++;
            p2++;

        }
        return true;
    }
}
