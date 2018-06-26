/*
https://leetcode.com/problems/maximize-distance-to-closest-person/description/
849. Maximize Distance to Closest Person
 */

package leetcode_849;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    private void run() {
        int[] seats = {1,0,0,0,1,0,1};
        System.out.println(maxDistToClosest(seats));
    }

    public int maxDistToClosest(int[] seats) {
        int k = -1, count = 0, max = 0;
        int length = seats.length;
        for (int i = 0; i < length; i++) {
            if (seats[i] == 1) {
                if (k == -1) {
                    max = count;
                }
                else {
                    max = Math.max(max, (count + 1) / 2);
                }
                k = i;
                count = 0;
                continue;
            }
            count ++;
        }

        max = Math.max(max, count);

        return max;
    }
}
