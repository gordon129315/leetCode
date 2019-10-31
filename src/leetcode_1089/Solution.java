//https://leetcode.com/problems/duplicate-zeros/
//1089. Duplicate Zeros

package leetcode_1089;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    private void run() {
        int[] arr = {1,0,2,3,0,4,5,0};
        System.out.println(Arrays.toString(duplicateZeros(arr)));
    }

    public int[] duplicateZeros(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            if (arr[i] == 0) {
                shift(arr, i + 1, length);
                arr[i + 1] = 0;
                i ++;
            }
        }
        return arr;
    }

    public void shift(int[] arr, int start, int length) {
        for (int i = length - 2; i >= start ; i--) {
            arr[i + 1] = arr[i];
        }
    }
}
