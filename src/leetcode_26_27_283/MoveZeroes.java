/*
https://leetcode.com/problems/move-zeroes/description/
283. Move Zeroes
 */

package leetcode_26_27_283;

public class MoveZeroes {
    public static void main(String[] args) {
        new MoveZeroes().run();
    }

    public void run() {
        int[] nums = {1, 2, 0, 2, 3,0};
        moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num);
        }

    }

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[index];
                nums[index ++] = nums[i];
                nums[i] = temp;
            }
        }
    }
}
