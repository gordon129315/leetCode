/*
https://leetcode.com/problems/buddy-strings/description/
859. Buddy Strings
 */

package leetcode_859;


import java.util.*;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    private void run() {
        String A = "ab";
        String B = "ab";

        System.out.println(buddyStrings(A, B));
    }

    public boolean buddyStrings(String A, String B) {
        int ALength = A.length();
        int BLength = B.length();
        if (ALength != BLength || ALength < 2 || BLength < 2) {
            return false;
        }

        if (A.equals(B)) {
            if (!isDuplicate(A)) {
                return false;
            }
        }

        List<Character> AList = new LinkedList<>();
        List<Character> BList = new LinkedList<>();

        for (int i = 0; i < ALength; i++) {
            char Ac = A.charAt(i);
            char Bc = B.charAt(i);
            if (Ac != Bc) {
                AList.add(Ac);
                BList.add(Bc);
            }
        }
        if (AList.isEmpty() && BList.isEmpty()) {
            return true;
        }
        else {
            if (AList.size() == 2 && BList.size() == 2) {
                Collections.reverse(BList);
                if (isEqual(AList, BList)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isDuplicate(String str) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            if (!set.contains(str.charAt(i))) {
                set.add(str.charAt(i));
            }
            else {
                return true;
            }
        }

        return false;
    }


    public boolean isEqual(List<Character> list1, List<Character> list2) {
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) != list2.get(i)){
                return false;
            }
        }
        return true;
    }
}
