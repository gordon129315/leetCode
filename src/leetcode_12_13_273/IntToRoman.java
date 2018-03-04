
/*
https://leetcode.com/problems/integer-to-roman/description/
12. Integer to Roman
 */

package leetcode_12_13_273;

public class IntToRoman {
    public static void main(String[] args) {
        new IntToRoman().run();
    }

    public void run() {
        int num = 999;
        System.out.println(intToRoman(num));
    }

    public String intToRoman(int num) {
        int[] values  = {1000,900 ,500,400 ,100,90  ,50 ,40  ,10 ,9   ,5  ,4   ,1  };
        String[] strs = {"M" ,"CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                sb.append(strs[i]);
                num -= values[i];
            }
        }

        return sb.toString();
    }
}
