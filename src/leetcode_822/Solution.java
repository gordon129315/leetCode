/*
https://leetcode.com/contest/weekly-contest-81/problems/card-flipping-game/
822. Card Flipping Game
 */


package leetcode_822;

import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    private void run() {
        int[] fronts = {1,2,4,4,7};
        int[] backs = {1,3,4,1,3};
        System.out.println(flipgame(fronts, backs));
    }

    public int flipgame(int[] fronts, int[] backs) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) {
                set.add(fronts[i]);
            }
        }

        int min = Integer.MAX_VALUE;
        min = minimun(fronts, set, min);
        min = minimun(backs, set, min);
        min = min == Integer.MAX_VALUE ? 0 : min;

        return min;
    }

    private int minimun(int[] fronts, HashSet<Integer> set, int min) {
        for (int front : fronts) {
            if (!set.contains(front)) {
                min = Math.min(min, front);
            }
        }
        return min;
    }
}
