package leetcode_873;

import java.util.HashSet;

public class Solution {

    public static void main(String[] args) {
        new Solution().run();
    }

    private void run() {
//        int[] A = {1,2,3,4,5,6,7,8};
//        int[] A = {1,10, 21,32};
//        int[] A = {1,3,7,11,12,14,18};
        int[] A = {2,4,7,8,9,10,14,15,18,23,32,50};
        System.out.println(lenLongestFibSubseq(A));

    }

    public int lenLongestFibSubseq(int[] A) {
        if (A.length < 3) {
            return 0;
        }

        int max = 0;

        for (int i = 2; i < A.length; i++) {
            max = Math.max(max, recurse(A, i - 1, A[i]));
        }

        return max > 2 ? max : 0;
    }

    private int recurse(int[] A, int index, int chosen) {
        if (index == 0) {
            return 0;
        }

        int value1 = fibSubseqNum(A, A[index], chosen);
        int value2 = recurse(A, index - 1, chosen);

        return Math.max(value1, value2);
    }

    private int fibSubseqNum(int[] A, int subtract, int minuend) {
        int count = 2;
        HashSet<Integer> set = new HashSet<>();
        for (int i : A) {
            set.add(i);
        }

        while (set.contains(minuend - subtract)) {
            count ++;
            remove(set, minuend - subtract);

            int temp = subtract;
            subtract = minuend - subtract;
            minuend = temp;

        }

        return count;
    }

    private void remove(HashSet<Integer> set, int num) {
        HashSet<Integer> removeSet = new HashSet<>();
        for (Integer i : set) {
            if (i >= num) {
                removeSet.add(i);
            }
        }
        set.removeAll(removeSet);
    }


}
