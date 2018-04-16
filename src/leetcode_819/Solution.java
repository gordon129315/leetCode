/*
https://leetcode.com/problems/most-common-word/description/
819. Most Common Word
 */

package leetcode_819;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        System.out.println(mostCommonWord(paragraph, banned));
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        if (paragraph == null || paragraph.length() == 0) {
            return "";
        }

        HashMap<String, Integer> map = new HashMap<>();
        String s = "";

        paragraph = paragraph.trim() + " ";
        for (int i = 0; i < paragraph.length(); i++) {
            char ch = paragraph.charAt(i);
            if (Character.isLetter(ch)) {
                s += ch;
            }
            else {
                if (s.length() != 0) {
                    String str = s.toLowerCase();
                    s = "";
                    map.put(str, map.getOrDefault(str, 0) + 1);
                }
            }
        }

        LinkedList<Integer> values = new LinkedList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            values.add(entry.getValue());
        }
        Collections.sort(values);
        Collections.reverse(values);

        LinkedList<String> strings = new LinkedList<>();
        for (int value : values) {
            strings.add(getStringByValue(map, value));
        }

        for (String str : strings) {
            if (!contain(banned, str)) {
                return str;
            }
        }

        return "";
    }

    private String getStringByValue(HashMap<String, Integer> map, int value) {
        String str = "";
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            if (entry.getValue() == value) {
                str = entry.getKey();
                iterator.remove();
                return str;
            }
        }

        return str;
    }

    private boolean contain(String[] arr, String str) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(str)) {
                return true;
            }
        }

        return false;
    }


}
