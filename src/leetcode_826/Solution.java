/*
https://leetcode.com/problems/most-profit-assigning-work/description/
826. Most Profit Assigning Work
 */

package leetcode_826;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    private void run() {
        int[] difficulty = {2,4,6,8,10};
        int[] profit = {10,20,30,40,50};
        int[] worker = {4,5,6,7};
        System.out.println(maxProfitAssignment(difficulty, profit, worker));


    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        rearrange(difficulty, profit);
        System.out.println(Arrays.toString(difficulty));
        System.out.println(Arrays.toString(profit));

        int total = 0;
        for (int i = 0; i < worker.length; i++) {
            for (int j = 0; j < profit.length; j++) {
                if (difficulty[j] <= worker[i]) {
                    total += profit[j];
                    break;
                }
            }
        }
        return total;
    }

    public void rearrange(int[] difficulty, int[] profit) {
        int length = profit.length;
        for(int i=0;i<length-1;i++){
            for(int j=0;j<length-1-i;j++){
                if(profit[j]<profit[j+1]){
                    int temp=profit[j];
                    profit[j]=profit[j+1];
                    profit[j+1]=temp;
                    int temp1=difficulty[j];
                    difficulty[j]=difficulty[j+1];
                    difficulty[j+1]=temp1;
                }
            }
        }

    }



}
