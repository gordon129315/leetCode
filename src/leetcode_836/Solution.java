/*
https://leetcode.com/problems/rectangle-overlap/description/
836. Rectangle Overlap
 */

package leetcode_836;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    private void run() {
        int[] rec1 = {7,8,13,15};
        int[] rec2 = {10,8,12,20};
        System.out.println(isRectangleOverlap(rec1, rec2));
    }

    //the origin point is the bottom-left point
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int length = rec1[0] < rec2[0] ? rec1[2] - rec1[0] : rec2[2] - rec2[0];
        int width = rec1[1] < rec2[1] ? rec1[3] - rec1[1] : rec2[3] - rec2[1];

        return Math.abs(rec1[0] - rec2[0]) < length && Math.abs(rec1[1] - rec2[1]) < width;

    }
}
