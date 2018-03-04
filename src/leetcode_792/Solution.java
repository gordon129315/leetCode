/*
https://leetcode.com/contest/weekly-contest-74/problems/number-of-matching-subsequences/
792. Number of Matching Subsequences
 */

package leetcode_792;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
        String S = "abcbde";
        String[] words = {"a", "bb", "acd", "ace"};
        System.out.println(numMatchingSubseq(S, words));
    }

    public int numMatchingSubseq(String S, String[] words) {
        if (words.length == 0) {
            return 0;
        }

        //Key -> char, Value -> index
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (map.containsKey(c)) {
                List<Integer> list =  map.get(c);
                list.add(i);
                map.put(c, list);
            }
            else {
                List<Integer> list = new LinkedList<>();
                list.add(i);
                map.put(c, list);
            }
        }
//        System.out.println(map);


        int count = 0;
        for (String word : words) {
            int currentIndex = -1;
            int match = 0;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (map.containsKey(c)) {
                    for (int index : map.get(c)) {
                        if (index > currentIndex) {
                            currentIndex = index;
                            match++;
                            break;
                        }
                    }
                }
                else {
                    break;
                }
            }
            if (match == word.length()) {
                count++;
//                System.out.println(word);
            }
        }
        return count;
    }
}
