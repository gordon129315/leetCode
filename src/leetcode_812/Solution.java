/*
https://leetcode.com/problems/largest-triangle-area/description/
812. Largest Triangle Area
 */

package leetcode_812;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
        int[][] points = {{0,0},{0,1},{1,0},{0,2},{2,0}};
        System.out.println(largestTriangleArea(points));
    }

    public double largestTriangleArea(int[][] points) {
        if (points.length < 3) {
            return 0.0;
        }

        int length = points.length;
        double area = 0.0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    area = Math.max(area, area(points[i], points[j], points[k]));
                }
            }
        }

        return area;
    }

    private double area(int[] a, int[] b, int[] c) {
        //S = 0.5*(x1*(y2-y3)+x2*(y3-y1)+x3*(y1-y2))
        return Math.abs(0.5 * (a[0] * (b[1] - c[1]) + b[0] * (c[1] - a[1]) + c[0] * (a[1] - b[1])));
    }

}
