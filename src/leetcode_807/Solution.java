/*
https://leetcode.com/contest/weekly-contest-77/problems/max-increase-to-keep-city-skyline/
807. Max Increase to Keep City Skyline
 */

package leetcode_807;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
        int[][] grid = {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
        System.out.println(maxIncreaseKeepingSkyline(grid));
    }

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] fromTop = limitFromTop(grid);
        int[] fromLeft = limitFromLeft(grid);
//        System.out.println(Arrays.toString(fromTop));
//        System.out.println(Arrays.toString(fromLeft));
        int cols = grid[0].length;
        int rows = grid.length;
        int increase = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                increase += Math.min(fromTop[j], fromLeft[i]) - grid[i][j];
            }
        }

        return increase;
    }

    private int[] limitFromTop(int[][] grid) {
        int cols = grid[0].length;
        int rows = grid.length;
        int[] fromTop = new int[cols];
        for (int j = 0; j < cols; j++) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < rows; i++) {
                max = Math.max(max, grid[i][j]);
            }
            fromTop[j] = max;
        }
        return fromTop;
    }

    private int[] limitFromLeft(int[][] grid) {
        int cols = grid[0].length;
        int rows = grid.length;
        int[] fromLeft = new int[rows];
        for (int i = 0; i < rows; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < cols; j++) {
                max = Math.max(max, grid[i][j]);
            }
            fromLeft[i] = max;
        }
        return fromLeft;
    }

}
