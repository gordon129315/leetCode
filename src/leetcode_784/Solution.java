
/*
https://leetcode.com/problems/letter-case-permutation/description/
784. Letter Case Permutation
 */

package leetcode_784;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
        String S = "a1b2";
        System.out.println(letterCasePermutation(S));
    }

    public List<String> letterCasePermutation(String S) {

        LinkedList<String> list = new LinkedList<>();
        if (S.equals("")) {
            list.add("");
            return list;
        }
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            int size = list.size();
            if (Character.isDigit(ch)) {
                if (list.isEmpty()) {
                    list.add(String.valueOf(ch));
                    continue;
                }
                for (int j = 0; j < size; j++) {
                    String str = list.getFirst();
                    list.add(str + String.valueOf(ch));
                    list.removeFirst();
                }
            }
            else {
                if (list.isEmpty()) {
                    list.add(String.valueOf(ch).toUpperCase());
                    list.add(String.valueOf(ch).toLowerCase());
                    continue;
                }
                for (int j = 0; j < size; j++) {
                    String str = list.getFirst();
                    list.add(str + String.valueOf(ch).toUpperCase());
                    list.add(str + String.valueOf(ch).toLowerCase());
                    list.removeFirst();
                }
            }
        }


        return list;
    }
}
