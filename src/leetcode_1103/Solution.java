//https://leetcode.com/problems/distribute-candies-to-people/
//1103. Distribute Candies to People

package leetcode_1103;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    private void run() {
        int candies = 10;
        int num_people = 3;

        int[] result = distributeCandies(candies, num_people);
        System.out.println(Arrays.toString(result));
    }

    public int[] distributeCandies(int candies, int num_people) {
        int[] people = new int[num_people];
        int step = 0;
        for (int i = 0; i < num_people; i++) {
            step ++;
            step = step < candies ? step : candies;
            people[i] += step;
            candies -= step;

            if (candies == 0) {
                break;
            }

            if (i == num_people - 1) {
                i = -1;
            }
        }


        return people;
    }
}
