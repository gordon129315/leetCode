
/*
https://leetcode.com/problems/jewels-and-stones/description/
771. Jewels and Stones
 */

package leetcode_771;

public class Solution {


    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
        String J = "aAb";
        String S = "aAAbbbb";
        System.out.println(numJewelsInStones(J, S));
    }


    public int numJewelsInStones(String J, String S) {
        if (J == null || S == null) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            for (int j = 0; j < J.length(); j++) {
                if (J.charAt(j) == S.charAt(i)) {
                    count ++;
                }
            }

        }
        return count;
    }
}
