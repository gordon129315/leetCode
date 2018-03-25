/*
https://leetcode.com/contest/weekly-contest-76/problems/minimum-swaps-to-make-sequences-increasing/
801. Minimum Swaps To Make Sequences Increasing
 */

package leetcode_801;

import java.util.HashMap;
import java.util.Objects;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
        int[] A = {1,3,5,4};
        int[] B = {1,2,3,7};
        System.out.println(minSwap(A, B));
    }

    public int minSwap(int[] A, int[] B) {
        HashMap<Combine, Integer> map = new HashMap<>();
        return recursion(A, B, A.length - 1, Integer.MAX_VALUE, Integer.MAX_VALUE, map);
    }

    private int recursion(int[] a, int[] b, int i, int limit_a, int limit_b, HashMap<Combine, Integer> map) {
        if (i < 0) {
            return 0;
        }

        Combine combine = new Combine(i, limit_a, limit_b);
        if (map.containsKey(combine)) {
            return map.get(combine);
        }

        if (a[i] < limit_a && b[i] < limit_b && a[i] < limit_b && b[i] < limit_a) {
            int n1 = recursion(a, b, i - 1, a[i], b[i], map);
            int n2 = recursion(a, b, i - 1, b[i], a[i], map) + 1;
            int n =Math.min(n1, n2);
            map.put(combine, n);
            return n;
        }
        else if ((a[i] < limit_a  && a[i] >= limit_b) || (b[i] < limit_b && b[i] >= limit_a)) {
            int n = recursion(a, b, i - 1, a[i], b[i], map);
            map.put(combine, n);
            return n;
        }
        else if (a[i] >= limit_a || b[i] >= limit_b) {
            int n = recursion(a, b, i - 1, b[i], a[i], map) + 1;
            map.put(combine, n);
            return n;
        }

        return 0;
    }

    class Combine {
        int i;
        int limit_a;
        int limit_b;

        public Combine(int i, int limit_a, int limit_b) {
            this.i = i;
            this.limit_a = limit_a;
            this.limit_b = limit_b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Combine combine = (Combine) o;
            return i == combine.i &&
                    limit_a == combine.limit_a &&
                    limit_b == combine.limit_b;
        }

        @Override
        public int hashCode() {

            return Objects.hash(i, limit_a, limit_b);
        }
    }
}
