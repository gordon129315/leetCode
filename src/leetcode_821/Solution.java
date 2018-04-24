/*
https://leetcode.com/contest/weekly-contest-81/problems/shortest-distance-to-a-character/
821. Shortest Distance to a Character
 */

package leetcode_821;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    private void run() {
        String S = "loveleetcode";
        char C = 'e';
        System.out.println(Arrays.toString(shortestToChar(S, C)));


    }

    public int[] shortestToChar(String S, char C) {

        int[] result = new int[S.length()];

        LinkedList<Integer> indexs = new LinkedList<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C) {
                indexs.add(i);
            }
        }

        for (int i = 0; i < S.length(); i++) {
            result[i] = distance(i, indexs);
        }

        return result;
    }

    private int distance(int value, LinkedList<Integer> indexs) {
        int min = Integer.MAX_VALUE;

        for (Integer index : indexs) {
            min = Math.min(min, Math.abs(value - index));
        }

        return min;
    }
}
