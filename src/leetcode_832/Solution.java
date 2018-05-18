/*
https://leetcode.com/problems/flipping-an-image/description/
832. Flipping an Image
 */

package leetcode_832;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    private void run() {
        int[][] A = {{1,1,0},{1,0,1},{0,0,0}};
        flipAndInvertImage(A);
        for (int[] arr : A) {
            System.out.println(Arrays.toString(arr));
        }

    }

    public int[][] flipAndInvertImage(int[][] A) {

        int length = A.length;
        for (int i = 0; i < length; i++) {
            flipAndInvert(A[i]);
        }

        return A;
    }

    private void flipAndInvert(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length / 2; i++) {
            swap(arr, i, length - 1 - i);
            flip(arr, i);
            flip(arr, length - 1 - i);
        }
        if (length % 2 == 1) {
            flip(arr, length / 2);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void flip(int[] arr, int i) {
        arr[i] = arr[i] == 0 ? 1 : 0;
    }

}
