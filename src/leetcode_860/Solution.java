/*
https://leetcode.com/problems/lemonade-change/description/

 */

package leetcode_860;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    private void run() {
        int[] bills = {5,5,5,10,20};
//        int[] bills = {5, 5, 10};
        System.out.println(lemonadeChange(bills));
    }

    public boolean lemonadeChange(int[] bills) {
        if (bills.length <= 1) {
            return true;
        }

        int five = 0;
        int ten = 0;
        int change = 0;

        for (int i = 0; i < bills.length; i++) {
            int money = bills[i];

            change = money - 5;

            while (change >= 10) {
                if (ten > 0) {
                    change -= 10;
                    ten --;
                }
                else {
                    break;
                }
            }

            while (change >= 5) {
                if (five > 0) {
                    change -= 5;
                    five --;
                }
                else {
                    break;
                }
            }

            if (change != 0) {
                return false;
            }

            if (money == 5) {
                five ++;
            }
            else if (money == 10) {
                ten ++;
            }

        }


        return true;
    }

}
