/*
https://leetcode.com/problems/binary-trees-with-factors/description/
823. Binary Trees With Factors
 */

package leetcode_823;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    private void run() {
//        int[] A = {2, 4, 5, 10, 20, 50};
//        int[] A = {2, 4};
        int[] A = {46,144,5040,4488,544,380,4410,34,11,5,3063808,5550,34496,12,540,28,18,13,2,1056,32710656,31,91872,23,26,240,18720,33,49,4,38,37,1457,3,799,557568,32,1400,47,10,20774,1296,9,21,92928,8704,29,2162,22,1883700,49588,1078,36,44,352,546,19,523370496,476,24,6000,42,30,8,16262400,61600,41,24150,1968,7056,7,35,16,87,20,2730,11616,10912,690,150,25,6,14,1689120,43,3128,27,197472,45,15,585,21645,39,40,2205,17,48,136};
        System.out.println(numFactoredBinaryTrees(A));
    }

    public int numFactoredBinaryTrees(int[] A) {
        HashMap<Integer, Long> map = new HashMap<>();
        long count = 0;
        Arrays.sort(A);
//        System.out.println(Arrays.toString(A));

        int length = A.length;
        for (int i = 0; i < length; i++) {
            map.put(A[i], 1L);
            long temp = factors(A[i], A, i, map);
            map.put(A[i], temp);
//            System.out.println(A[i] + " --- " + map.get(A[i]));
//            System.out.println();
            count += temp;
        }

        return (int) (count % (Math.pow(10, 9) + 7));
    }

    public long factors(int root, int[] A,int index, Map<Integer, Long> map) {
        long times = 1L;

        for (int i = 0; i < index; i++) {
            if (root % A[i] == 0) {
                int result = root / A[i];

                if (map.containsKey(A[i]) && map.containsKey(result)) {
//                    System.out.println(root + " ----- " + A[i]+ "("+ map.get(A[i]) + ")" + " * " + result+ "("+ map.get(result) + ")");
                    times += map.get(A[i]) * map.get(result);
                }
            }
        }
        return times;
    }
}
