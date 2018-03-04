/*
https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
26. Remove Duplicates from Sorted Array
 */

package leetcode_26_27_283;

public class RemoveDuplicates {
    public static void main(String[] args) {
        new RemoveDuplicates().run();
    }

    public void run() {
        int[] nums = {1, 1, 2};
        System.out.println(removeDuplicates(nums));
    }


    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }

        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }
        return ++j;
    }
}
