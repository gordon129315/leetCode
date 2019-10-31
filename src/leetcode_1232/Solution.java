//https://leetcode.com/problems/check-if-it-is-a-straight-line/
//1232. Check If It Is a Straight Line

package leetcode_1232;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
        int[][] coordinates = {{-4,-3},{1,0},{3,-1},{0,-1},{-5,2}};
        System.out.println(checkStraightLine(coordinates));
    }

    public boolean checkStraightLine(int[][] coordinates) {
        int length = coordinates.length;
        if (length <= 2) {
            return true;
        }

        double k = (coordinates[1][1] - coordinates[0][1]) / (double)(coordinates[1][0] - coordinates[0][0]);

        for (int i = 1; i < length; i++) {
            if (k != (coordinates[i][1] - coordinates[i - 1][1]) / (double)(coordinates[i][0] - coordinates[i -1][0])) {
                return false;
            }
        }
        return true;
    }
}
