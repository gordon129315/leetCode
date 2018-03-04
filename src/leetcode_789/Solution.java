/*
https://leetcode.com/contest/weekly-contest-73/problems/escape-the-ghosts/
789. Escape The Ghosts
 */

package leetcode_789;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
//        int[][] ghosts = {{1, 0}, {0, 3}};
//        int[] target = {0, 1};
        int[][] ghosts = {{28,13},{26,15},{20,21},{23,18},{4,5},{16,17},{38,3},{24,17},{34,7},{-6,-5}};
        int[] target = {20,-6};
        System.out.println(escapeGhosts(ghosts, target));
    }

    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int ghostDistance;
        int targetDistance = Math.abs(target[0]) + Math.abs(target[1]);
//        System.out.println("T : " + targetDistance);
        for (int i = 0; i < ghosts.length; i++) {
            ghostDistance = Math.abs(ghosts[i][0] - target[0]) + Math.abs(ghosts[i][1] - target[1]);
//            System.out.println("G : " + ghostDistance);
            if (ghostDistance <= targetDistance) {
                return false;
            }
        }

        return true;
    }
}
