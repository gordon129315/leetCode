/*
https://leetcode.com/problems/goat-latin/description/
824. Goat Latin
 */


package leetcode_824;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    private void run() {
        String S = "I speak Goat Latin";
        System.out.println(toGoatLatin(S));
    }

    public String toGoatLatin(String S) {
        S += " ";
        int aTimes = 0;
        String result = "";
        String temp = "";
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == ' ') {
                if (temp.startsWith("a") || temp.startsWith("e") || temp.startsWith("i") || temp.startsWith("o") || temp.startsWith("u") ||
                        temp.startsWith("A") || temp.startsWith("E") || temp.startsWith("I") || temp.startsWith("O") || temp.startsWith("U")) {
                    temp += generate(aTimes);
                }
                else {
                    temp = temp.substring(1) + temp.charAt(0) + generate(aTimes);
                }
                result += temp + " ";
                temp = "";
                aTimes++;
            }
            else {
                temp += c;
            }
        }
        return result.trim();
    }

    public String generate(int aTimes) {
        String str = "m";
        for (int i = 0; i < aTimes + 2; i++) {
            str += "a";
        }
        return str;
    }

}
