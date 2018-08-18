/*
https://leetcode.com/problems/transpose-matrix/description/
867. Transpose Matrix
 */

package leetcode_867;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    private void run() {
        int[][] A = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] arr = transpose(A);
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public int[][] transpose(int[][] A) {

        int[][] arr = new int[A[0].length][A.length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                arr[j][i] = A[i][j];
            }
        }

        return arr;
    }
}
