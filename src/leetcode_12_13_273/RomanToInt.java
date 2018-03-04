
/*
https://leetcode.com/problems/roman-to-integer/description/
13. Roman to Integer
 */

package leetcode_12_13_273;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    public static void main(String[] args) {
        new RomanToInt().run();
    }

    public void run() {
        String str = "I";
        System.out.println(romanToInt(str.toUpperCase()));
    }

    public int romanToInt(String s) {
        if (s == null || s.equals("")) {
            return -1;
        }

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum = map.get(s.charAt(s.length() - 1));
        for (int i = 0; i < s.length() - 1; i++) {
            if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                sum -= map.get(s.charAt(i));
            }
            else {
                sum += map.get(s.charAt(i));
            }
        }
        return sum;
    }
}
