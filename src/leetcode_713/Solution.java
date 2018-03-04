/*
https://leetcode.com/problems/subarray-product-less-than-k/description/
713. Subarray Product Less Than K
 */


package leetcode_713;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
//        int[] arr = {10, 5, 2, 6};
        int[] arr = {5,2,2,2,2,2};
//        int[] arr = {1,1,1,1,1};


        System.out.println(numSubarrayProductLessThanK(arr, 100));
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0){
            return 0;
        }

        int res = 1;
        int i = 0;
        int j = 0;
        int count = 0;

        while (j < nums.length) {
            res *= nums[j];
            while (res >= k && i <= j) {
                res /= nums[i];
                i++;
            }
            count += j - i + 1;
            j++;
        }
        return count;
    }

}
