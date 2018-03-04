
/*
https://leetcode.com/problems/k-th-symbol-in-grammar/description/
779. K-th Symbol in Grammar
 */




package leetcode_779;

import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
//        int N = 4;
//        int K = 4;
        int N = 30;
        int K = 434991989;
        System.out.println(kthGrammar_2(N, K));
    }

    public int kthGrammar_2(int N, int K){
        LinkedList<Integer> list = new LinkedList<>();
        String str = "0";
        int i = 0;
        int k = K;
        while(k > 1) {
            k = (k + 1) / 2;
            list.add(k);
        }
//        System.out.println(list);
        while (!list.isEmpty()) {
            i = list.removeLast();
//            System.out.println(i);
            str = str.charAt( (i + 1) % 2) == '0' ? "01" : "10";
//            System.out.println(str);
        }
        return Integer.parseInt(str.charAt((K + 1) % 2) +"");
    }




















    public int kthGrammar(int N, int K) {
        String str = "";
        if (N == 1) {
            str = "0";
            return Integer.parseInt(str.charAt(K - 1) + "");
        }
        else if (N ==2) {
            str = "01";
            return Integer.parseInt(str.charAt(K - 1) + "");
        }
        System.out.println("0");
        System.out.println("01");
        str = "6";
        System.out.println(str);
        for (int i = 3; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '6') {
                    sb.append("69");
                }
                else if (str.charAt(j) == '9') {
                    sb.append("96");
                }
            }
            str = sb.toString();
            System.out.println(str);
        }

        int n = (K - 1) / 4;
        int k = (K - 1) % 4;
        int dec = Integer.valueOf(str.charAt(n) + "",16);    //十六进制 -> 十进制
        String s = Integer.toBinaryString(dec);              //十进制 -> 二进制
        if (s.length() < 4) {
            int gap = 4 - s.length();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < gap; i++) {
                sb.append('0');
            }
            s = sb.append(s).toString();
        }
        System.out.println("s:" + s);

        return Integer.parseInt(s.charAt(k) + "");
    }

}
