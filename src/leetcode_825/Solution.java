/*
https://leetcode.com/problems/friends-of-appropriate-ages/description/
825. Friends Of Appropriate Ages
 */

package leetcode_825;


import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    private void run() {
        int[] ages = {20,30,100,110,120};
        System.out.println(numFriendRequests(ages));
    }

    public int numFriendRequests_1(int[] ages) {
        Arrays.sort(ages);
//        System.out.println(Arrays.toString(ages));
        int count = 0;

        int length = ages.length;
        for (int i = length - 1; i >= 1; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (ages[j] > 0.5 * ages[i] + 7 && ages[j] <= ages[i]) {
//                    System.out.println(ages[j] + "----" + ages[i]);
                    count++;
                    if (ages[j] == ages[i]) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int count = 0;
        int maxRequest = 0;
        int length = ages.length;
        for (int i = 0; i < length - 1; i++) {
            maxRequest = (ages[i] - 7) * 2;
            for (int j = i + 1; j < length; j++) {
                if (maxRequest > ages[j]) {
                    count++;
                    if (ages[i] == ages[j]) {
                        count++;
                    }
                }
                else {
                    break;
                }
            }
        }

        return count;
    }

}
