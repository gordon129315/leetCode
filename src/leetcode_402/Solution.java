
/*
https://leetcode.com/problems/remove-k-digits/description/
402. Remove K Digits

 */

package leetcode_402;

import java.util.LinkedList;


public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
        String num = "101100";
        int k = 2;
        System.out.println(removeKdigits(num, k));
    }


    public String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < num.length(); i++) {
            list.add(Integer.parseInt(num.charAt(i) + ""));
        }

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < list.size() - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    list.remove(j);
                    break;
                }
                if (j == list.size() - 2 && list.get(j) <= list.get(j + 1)){
                    list.removeLast();
                }

            }
            while (list.get(0) == 0){
                list.remove(0);
                if (list.isEmpty()) {
                    return "0";
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i : list) {
            sb.append(i);
        }
        return sb.toString();
    }


}
