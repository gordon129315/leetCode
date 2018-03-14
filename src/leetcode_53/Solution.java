package leetcode_53;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(maxSubArray(nums));
    }

    //Kadane's Algorithm
    public int maxSubArray(int[] nums) {
        int max_global = nums[0];
        int max_current = nums[0];
        for (int i = 1; i < nums.length; i++) {
//            if (max_current < 0) {
//                max_current = nums[i];
//            }
//            else {
//                max_current += nums[i];
//            }
            max_current = Math.max(max_current + nums[i], nums[i]);   //the same to above code.
            max_global = Math.max(max_current, max_global);
        }
        return max_global;
    }






    public int maxSubArray_2(int[] nums) {

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int total = 0;
            for (int j = i; j < nums.length; j++) {
                total += nums[j];
                max = Math.max(max, total);
            }
        }
        return max;
    }
}
