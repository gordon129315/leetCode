package leetcode_804;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
        String[] words = {"gin", "zen", "gig", "msg"};
        System.out.println(uniqueMorseRepresentations(words));
    }

    public int uniqueMorseRepresentations(String[] words) {
        if (words.length == 0 || words.length == 1) {
            return words.length;
        }

        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        List<String> list = new LinkedList<>();

        for (String word : words) {
            String morseCode = "";
            for (int i = 0; i < word.length(); i++) {
                String charCode = codes[word.charAt(i) - 'a'];
                morseCode += charCode;
            }
            if (!list.contains(morseCode)) {
                list.add(morseCode);
            }
        }

        return list.size();
    }
}
