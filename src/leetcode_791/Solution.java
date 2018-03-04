/*
https://leetcode.com/contest/weekly-contest-73/problems/custom-sort-string/
791. Custom Sort String
 */

package leetcode_791;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
        String S = "cba";
        String T = "abcdabbbbb";
        System.out.println(customSortString(S, T));
    }

    public String customSortString(String S, String T) {
        if (S.length() == 0 || T.length() == 0) {
            return T;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < T.length(); i++) {
            char key = T.charAt(i);
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            }
            else {
                map.put(key, 1);
            }
        }
//        System.out.println(map);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char key = S.charAt(i);
            if (map.containsKey(key)) {
                for (int j = 0; j < map.get(key); j++) {
                    sb.append(key);
                }
                map.remove(key);
            }
        }
        for (char key: map.keySet()){
            for (int j = 0; j < map.get(key); j++) {
                sb.append(key);
            }
        }
        return sb.toString();
    }
}
