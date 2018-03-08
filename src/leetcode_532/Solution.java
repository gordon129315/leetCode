
/*
https://leetcode.com/contest/leetcode-weekly-contest-22/problems/k-diff-pairs-in-an-array/
532. K-diff Pairs in an Array
 */


package leetcode_532;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
        int[] nums = {3,1,4,1,5,5,1};
        int k = 1;
        System.out.println(findPairs(nums, k));
    }

    public int findPairs(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            map.put(key, 1 + map.getOrDefault(key, 0));
        }
        int cnt = 0;
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        if (k == 0) {

//            for (int key : map.keySet()) {
//                if (map.get(key) > 1) {
//                    cnt++;
//                }
//            }

            for (Map.Entry<Integer, Integer> entry: entries) {
                if (entry.getValue() > 1) {
                    cnt++;
                }
            }
            return cnt;
        }

        for (Map.Entry<Integer, Integer> entry: entries) {
            int target = entry.getKey() + k;
            if (map.containsKey(target)) {
                cnt++;
            }
        }

        return cnt;
    }
}
