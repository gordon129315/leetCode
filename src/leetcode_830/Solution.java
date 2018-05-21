/*
https://leetcode.com/problems/positions-of-large-groups/description/
830. Positions of Large Groups
 */

package leetcode_830;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    private void run() {
        String S = "abbxxxxzzy";
        System.out.println(largeGroupPositions(S));
    }

    public List<List<Integer>> largeGroupPositions(String S) {
        S += " ";

        List<List<Integer>> result = new LinkedList<>();
        char temp = ' ';
        int startIndex = 0;
        int count = 1;


        int length = S.length();
        for (int i = 0; i < length; i++) {
            if (S.charAt(i) != temp) {
                if (count >= 3) {
                    List<Integer> list = new LinkedList<>();
                    list.add(startIndex);
                    list.add(i - 1);
                    result.add(list);
                }

                startIndex = i;
                temp = S.charAt(i);
                count = 1;
            }
            else {
                count++;
            }
        }
        return result;
    }
}
