
/*
https://leetcode.com/problems/toeplitz-matrix/description/
766. Toeplitz Matrix
 */

package leetcode_766;


public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
        int [][] matrix = {{1,2,3,4},{5,1,2,3},{8,5,1,2}};
        System.out.println(isToeplitzMatrix(matrix));
        System.out.println(isToeplitzMatrix_2(matrix));
    }

    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int j = 0; j < matrix[0].length; j++) {
            if (!check(matrix, 0, j)) {
                return false;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (!check(matrix, i, 0)) {
                return false;
            }
        }
        return true;
    }

    private boolean check(int[][] matrix, int i, int j) {
        int m = matrix[0].length;
        int n = matrix.length;
        int temp = matrix[i][j];

        while (i < n && j < m) {
            if (temp != matrix[i++][j++]) {
                return false;
            }
        }
        return true;
    }

    public boolean isToeplitzMatrix_2(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[0].length - 1; j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
