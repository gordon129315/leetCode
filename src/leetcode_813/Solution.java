/*
https://leetcode.com/problems/largest-sum-of-averages/description/
813. Largest Sum of Averages
 */

package leetcode_813;

import java.util.HashMap;
import java.util.Objects;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
        int[] A = {9,1,2,3,9};
        int K = 3;
//        int K = 1;
        System.out.println(largestSumOfAverages(A, K));

//        System.out.println(average(A, 1, 2));
    }

    public double largestSumOfAverages(int[] A, int K) {
        HashMap<Combine, Double> map = new HashMap<>();
        return recursion(A, K - 1, A.length - 1, A.length, map);

    }

    private double recursion(int[] arr, int depart, int from, int to, HashMap<Combine, Double> map) {
        if (depart == 0) {
            return average(arr, 0, from + 1);
        }
        if (from <= depart) {
            double sum = 0;
            for (int i = 0; i < from; i++) {
                sum += arr[i];
            }
            sum += average(arr, from, to);
            return sum;
        }

        if (map.containsKey(new Combine(depart, from, to))) {
            return map.get(new Combine(depart, from, to));
        }

        double sum1 = recursion(arr, depart, from - 1, to, map);
        double sum2 = average(arr,from, to) + recursion(arr, depart - 1, from - 1, from, map);

        double max = Math.max(sum1, sum2);
        map.put(new Combine(depart, from, to), max);

        return max;
    }

    private double average(int[] arr, int from, int to) {
        double sum = 0;
        for (int i = from; i < to; i++) {
            sum += arr[i];
        }
        return sum / (to - from);
    }

    class Combine {
        int depart;
        int from;
        int to;

        public Combine(int depart, int from, int to) {
            this.depart = depart;
            this.from = from;
            this.to = to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Combine combine = (Combine) o;
            return depart == combine.depart &&
                    from == combine.from &&
                    to == combine.to;
        }

        @Override
        public int hashCode() {

            return Objects.hash(depart, from, to);
        }
    }




}
