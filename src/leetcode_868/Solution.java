/*
https://leetcode.com/problems/binary-gap/description/
868. Binary Gap
 */


package leetcode_868;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    private void run() {
        System.out.println(binaryGap(22));

    }

    public int binaryGap(int N) {
        int max = 0;
        String s = Integer.toBinaryString(N);
        int index = 0;
        int length = s.length();

        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '1') {
                max = Math.max(max, i - index);
                index = i;
            }
        }
        return max;
    }
}
