/*
https://leetcode.com/problems/reverse-integer/description/
7. Reverse Integer
 */

package leetcode_7_344;

public class ReverseInteger {
    public static void main(String[] args) {
        new ReverseInteger().run();
    }

    public void run() {
        System.out.println(reverse(1534236469));
    }

    public int reverse(int x) {
        boolean negative = false;    //false 正数    true  负数

        if (x < 0) {
            negative = true;
            x = Math.abs(x);
        }

        String str_value = String.valueOf(x);
        StringBuilder sb_reverse_integer = new StringBuilder();

        if (negative) {
            sb_reverse_integer.append("-");
        }

        for (int i = str_value.length() - 1; i >= 0 ; i--) {
            sb_reverse_integer.append(str_value.charAt(i));
        }

        String str_reverse_integer = sb_reverse_integer.toString();

        int reverse_integer = 0;

        try {
            reverse_integer = Integer.parseInt(str_reverse_integer);
        }
        catch (NumberFormatException e) {
            reverse_integer = 0;
        }

        return reverse_integer;
    }
}
