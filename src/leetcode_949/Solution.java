/*
949. Largest Time for Given Digits
https://leetcode.com/problems/largest-time-for-given-digits/
 */

package leetcode_949;


import java.util.HashSet;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    private void run() {
        int[] A = {2,0,6,6};
        System.out.println(largestTimeFromDigits(A));
    }

    public String largestTimeFromDigits(int[] A) {
        String str = "";
        int[] indexs = {0,1,2,3};
        LinkedList<String> indexList = new LinkedList<>();
        indexPermutation(str,indexs,indexList);
//        System.out.println(indexList);

        LinkedList<String> times = new LinkedList<>();

        String timeStr = "";
        for (String indexOrder : indexList) {
            for (int i = 0; i < indexOrder.length(); i++) {
                int index = Integer.parseInt(indexOrder.charAt(i) + "");
                timeStr += A[index];
                if (timeStr.length() == 2) {
                    timeStr += ":";
                }
            }
            if (isLegalTime(timeStr)) {
                times.add(timeStr);
            }
            timeStr = "";
        }
//        System.out.println(times);
        if (times.size() == 0) {
            return "";
        }

        int[] totalMins = new int[times.size()];
        for (int i = 0; i < totalMins.length; i++) {
            String[] split = times.get(i).split(":");
            int hour = Integer.parseInt(split[0]);
            int min = Integer.parseInt(split[1]);
            totalMins[i] = 60 * hour + min;
        }

        int maxMin = findMaxMin(totalMins);

        return String.format("%02d:%02d", maxMin / 60, maxMin % 60);
    }

    private int findMaxMin(int[] totalMins) {
        int max = 0;
        for (int i = 0; i < totalMins.length; i++) {
            max = Math.max(max,totalMins[i]);
        }
        return max;
    }

    public boolean isLegalTime(String timeStr) {
        String[] split = timeStr.split(":");
        int hour = Integer.parseInt(split[0]);
        int min = Integer.parseInt(split[1]);
        return hour < 24 && min < 60;
    }

    public void indexPermutation(String str, int[] a, LinkedList<String> indexList) {
        if (str.length() == 4) {
//            System.out.println(str);
            if (!isDuplicated(str)) {
                indexList.add(str);
            }

            return;
        }
        for (int i = 0; i < a.length; i++) {
            indexPermutation(str + a[i], a, indexList);
        }
    }

    public boolean isDuplicated(String str) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (set.contains(c)) {
                return true;
            }
            set.add(c);
        }
        return false;
    }


}
