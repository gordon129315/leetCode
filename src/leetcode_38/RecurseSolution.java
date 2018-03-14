/*
https://leetcode.com/problems/count-and-say/description/
38. Count and Say
 */

package leetcode_38;

public class RecurseSolution {
    public static void main(String[] args) {
        new RecurseSolution().run();
    }

    public void run() {
        System.out.println(countAndSay(3));
    }

    public String countAndSay(int n) {
        if (n <= 0) {
            return "1";
        }

        String str = "1";
        str = recurse(n, 1, str);
        return str;
    }

    private String recurse(int n, int k, String str) {
        if (k == n) {
            return str;
        }
        String newStr = "";
        int count = 1;
        char c = str.charAt(0);
        for (int i = 0; i < str.length() - 1; i++) {
            if (c == str.charAt(i + 1)) {
                count++;
            }
            else {
                newStr += String.valueOf(count) + c;
                count = 1;
                c = str.charAt(i + 1);
            }
        }
        newStr += String.valueOf(count) + c;
        return recurse(n, k + 1, newStr);
    }

}
