/*
https://leetcode.com/problems/remove-element/description/
27. Remove Element
 */

package leetcode_26_27_283;

public class RemoveElement {
    public static void main(String[] args) {
        new RemoveElement().run();
    }

    public void run() {
        int[] nums = {1, 2, 2, 3};
        int val = 2;
        System.out.println(removeElement(nums, val));
    }


    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index ++] = nums[i];
            }
        }
        return index;
    }
}
