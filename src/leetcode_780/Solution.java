/*
https://leetcode.com/problems/reaching-points/description/
780. Reaching Points
 */

package leetcode_780;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
//        int sx = 1, sy = 1, tx = 3, ty = 5;
//        int sx = 1, sy = 3, tx = 1000000000, ty = 3;
        int sx = 1, sy = 2, tx = 999999999, ty =2;
        System.out.println(reachingPoints(sx, sy, tx, ty));
    }

    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if (sx == tx && sy == ty) {
            return true;
        }
        else if (tx == ty) {
            return false;
        }

        while (tx >= sx && ty >= sy) {
            if (tx > ty) {
                tx %=ty;
            }
            else if (tx <= ty) {
                ty %= tx;
            }

            if (sx == tx && (ty - sy) % sx == 0) {
                return true;
            }
            else if (sy == ty && (tx - sx) % sy == 0) {
                return true;
            }
        }

        return false;
    }
}
