/*
https://leetcode.com/problems/reverse-string/description/
344. Reverse String
 */

package leetcode_7_344;

public class ReverseString {
    public static void main(String[] args) {
        new ReverseString().run();
    }

    public void run() {
        String str = "abcdefg";
//        String str = "";
        System.out.println(reverseString(str));
    }

    public String reverseString(String str) {
        if (str.length() == 0 || str.length() == 1) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

}
