
/*
https://leetcode.com/problems/reorganize-string/description/
767. Reorganize String

 */


package leetcode_767;


import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class Solution {
    private LinkedList<String> list = new LinkedList<>();

    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
        String S = "abababcccaaaa";
        System.out.println(reorganizeString(S));

    }

    public String reorganizeString(String S) {
        if (S.length() == 1){
            return S;
        }
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            }
            else {
                map.put(c, 1);
            }
        }

        System.out.println(map);
//        removeZeroKey(map);
//        System.out.println(map);

        while (map.keySet().size() > 1) {
            for (char key : map.keySet()) {
                sb.append(key);
                map.put(key, map.get(key) - 1);
            }
            removeZeroKey(map);
            System.out.println(map);
        }

        if (!map.isEmpty()) {
            for (char key : map.keySet()) {
                System.out.println(key);
                for (int i = 0; i < map.get(key); i++) {
                    for (int j = 0; j < sb.length(); j++) {
                        if (j == 0 && sb.charAt(j) != key) {
                            sb.insert(0, key);
                            break;
                        }
                        else if (j > 0 && sb.charAt(j - 1) != key && sb.charAt(j) != key) {
                            sb.insert(j, key);
                            break;
                        }
                        else if (j == sb.length() - 1 && sb.charAt(j) != key) {
                            sb.append(key);
                            break;
                        }
                        else if (j == sb.length() - 1){
                            return "";
                        }

                    }
                }
            }
        }


        return sb.toString();
    }

    private void removeZeroKey(Map<Character, Integer> map) {
        Iterator<Character> iter = map.keySet().iterator();
        while (iter.hasNext()) {
            char key = iter.next();
            if (map.get(key) == 0) {
                iter.remove();
            }

        }
    }
}
