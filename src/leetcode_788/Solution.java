/*
https://leetcode.com/contest/weekly-contest-73/problems/rotated-digits/
788. Rotated Digits
 */

package leetcode_788;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
        System.out.println(rotatedDigits(30));
    }

    public int rotatedDigits(int N) {
        int cnt = 0;
        String temp;
        char c;
        String ref = "0125689";
        for (int i = 1; i <= N; i++) {
            temp = String.valueOf(i);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < temp.length(); j++) {
                c = temp.charAt(j);
                if (ref.indexOf(String.valueOf(c)) == -1){
                    break;
                }
                switch (c){
                    case '2': sb.append('5'); break;
                    case '5': sb.append('2'); break;
                    case '6': sb.append('9'); break;
                    case '9': sb.append('6'); break;
                    case '1': sb.append('1'); break;
                    case '0': sb.append('0'); break;
                    case '8': sb.append('8'); break;
                    default:  break;
                }
            }
            if (sb.toString().length() == temp.length() && !sb.toString().equals(temp)) {
                cnt++;
            }
        }
        return cnt;
    }
}
