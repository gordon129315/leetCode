/*
953. Verifying an Alien Dictionary
https://leetcode.com/problems/verifying-an-alien-dictionary/
 */


package leetcode_953;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    private void run() {
        String[] words = {"hello","leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(isAlienSorted(words, order));
    }

    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < words.length - 1; i++) {
            String word_1 = words[i];
            String word_2 = words[i + 1];

            for (int j = 0; j < word_1.length(); j++) {
                if (j >= word_2.length()) {
                    return false;
                }
                if (order.indexOf(word_1.charAt(j)) > order.indexOf(word_2.charAt(j))) {
                    return false;
                }
                else if (order.indexOf(word_1.charAt(j)) < order.indexOf(word_2.charAt(j))) {
                    break;
                }
            }
        }

        return true;
    }
}
