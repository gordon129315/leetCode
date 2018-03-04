/*
https://leetcode.com/problems/rabbits-in-forest/description/
781. Rabbits in Forest
 */

package leetcode_781;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
        int[] answers = {1, 1, 1, 1, 1, 2};
        System.out.println(numRabbits(answers));
    }

    public int numRabbits(int[] answers) {
        if (answers.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : answers) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            }
            else {
                map.put(i, 1);
            }
        }

//        System.out.println(map);

        int result = 0;

        for (int i: map.keySet()) {
            result += (((map.get(i) - 1) / (i + 1)) + 1) * (i + 1);
        }

        return result;
    }
}
