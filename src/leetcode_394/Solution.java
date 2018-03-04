
/*
https://leetcode.com/problems/decode-string/description/
394. Decode String
 */

package leetcode_394;


import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
        String s = "2[abc]3[cd]ef";
        System.out.println(decodeString(s));
    }

    public String decodeString(String s) {
        if (s.equals("")) {
            return "";
        }

        LinkedList<Character> charList = new LinkedList<>();
        LinkedList<Integer> numList = new LinkedList<>();

        StringBuilder num = new StringBuilder();
        StringBuilder subList = new StringBuilder();

        char c = ' ';
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (Character.isDigit(c)) {
                num.append(c);
            }
            else if (c == '[') {
                numList.add(Integer.parseInt(num.toString()));
                num.delete(0, num.length());
                charList.add('[');
            }
            else if (c == ']') {
                int index = charList.lastIndexOf('[');
                charList.remove(index);
                int times = numList.getLast();
                numList.removeLast();
                for (int k = 1; k < times ; k++) {
                    for (int j = index; j < charList.size(); j++) {
                        subList.append(charList.get(j));
                    }
                }
                for (int j = 0; j < subList.length(); j++) {
                    charList.add(subList.charAt(j));
                }
                subList.delete(0, subList.length());
            }
            else if (!Character.isDigit(c)){
                charList.add(c);
            }
        }

        StringBuilder result = new StringBuilder();
        for (char ch : charList) {
            result.append(ch);
        }

        return result.toString();
    }
}
