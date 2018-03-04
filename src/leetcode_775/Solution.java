package leetcode_775;

/*
https://leetcode.com/problems/global-and-local-inversions/description/
775. Global and Local Inversions My SubmissionsBack to Contest

 */


public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
        int[] A = new int[]{1,3,2,0};
        System.out.println(isIdealPermutation(A));
    }


    public boolean isIdealPermutation(int[] A) {
        if (A == null) {
            return false;
        }

        int current_max = 0;
        for (int i = 0; i < A.length - 2; i++) {
            current_max = Math.max(current_max, A[i]);
            if (current_max > A[i+2]) {
                return false;
            }
        }
        return true;
    }


    public boolean isIdealPermutation_2(int[] A) {
        if (A == null) {
            return false;
        }

        int global_inversion = 0;
        int local_inversion = 0;
        int length = A.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (A[i] > A[j]) {
                    global_inversion ++;
                    if (j == i + 1) {
                        local_inversion ++;
                    }
                }
            }
        }
        return global_inversion == local_inversion;
    }
}
