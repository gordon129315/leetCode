/*
https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
852. Peak Index in a Mountain Array
 */
package leetcode_852;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    private void run() {
        int[] A = {0,2,1,0};
        System.out.println(peakIndexInMountainArray(A));
    }

    public int peakIndexInMountainArray(int[] A) {
        int length = A.length;

        if (A[0] > A[1]) {
            return 0;
        } else if (A[length - 1] > A[length - 2]) {
            return length - 1;
        }

        for (int i = 1; i < length - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                return i;
            }
        }

        return 0;
    }
}
