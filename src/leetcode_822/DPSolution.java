/*
https://leetcode.com/contest/weekly-contest-81/problems/card-flipping-game/
822. Card Flipping Game
 */

package leetcode_822;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DPSolution {
    public static void main(String[] args) {
        new DPSolution().run();
    }

    private void run() {
        int[] fronts = {1,2,4,4,7};
        int[] backs = {1,3,4,1,3};
        System.out.println(flipgame(fronts, backs));
    }

    public int flipgame(int[] fronts, int[] backs) {
        Map<Combine, Integer> map = new HashMap<>();
        int result = recursion(fronts, backs, fronts.length - 1, map);
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    private int recursion(int[] fronts, int[] backs, int index, Map<Combine, Integer> map) {
        if (index < 0) {
            return Integer.MAX_VALUE;
        }

        if (map.containsKey(new Combine(fronts, backs, index))) {
            return map.get(new Combine(fronts, backs, index));
        }

        int value1 = Math.min(recursion(fronts, backs, index - 1, map), contain(fronts, backs[index]) ? Integer.MAX_VALUE : backs[index]);
        flip(index, fronts, backs);
        int value2 = Math.min(recursion(fronts, backs, index - 1, map), contain(fronts, backs[index]) ? Integer.MAX_VALUE : backs[index]);
        int min = Math.min(value1, value2);
        map.put(new Combine(fronts, backs, index), min);
        return min;
    }

    public void flip(int index, int[] fronts, int[] backs) {
        int temp = fronts[index];
        fronts[index] = backs[index];
        backs[index] = temp;
    }

    public boolean contain(int[] fronts, int value) {
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == value) {
                return true;
            }
        }
        return false;
    }

    class Combine {
        int[] fronts;
        int[] backs;
        int index;

        public Combine(int[] fronts, int[] backs, int index) {
            this.fronts = fronts;
            this.backs = backs;
            this.index = index;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Combine combine = (Combine) o;
            return index == combine.index &&
                    Arrays.equals(fronts, combine.fronts) &&
                    Arrays.equals(backs, combine.backs);
        }

        @Override
        public int hashCode() {

            int result = Objects.hash(index);
            result = 31 * result + Arrays.hashCode(fronts);
            result = 31 * result + Arrays.hashCode(backs);
            return result;
        }
    }
}
