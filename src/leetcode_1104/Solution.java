//https://leetcode.com/problems/path-in-zigzag-labelled-binary-tree/submissions/
//1104. Path In Zigzag Labelled Binary Tree

package leetcode_1104;

import java.util.LinkedList;
import java.util.List;



public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
        int label = 26;
        System.out.println(pathInZigZagTree(label));
    }

    public List<Integer> pathInZigZagTree(int label) {
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(label);
        int layer = (int)Math.floor(log2(label));
//        System.out.println(layer);
        int parentTemp;
        while (layer > 0) {
            parentTemp = label % 2 == 0 ? label / 2 : (label - 1) / 2;
            label = (int)(Math.pow(2, layer) - 1 - parentTemp + Math.pow(2, layer - 1));
            list.addFirst(label);
            layer --;
        }
        return list;
    }

    public double log2(int num) {
        return Math.log10(num)/Math.log10(2);
    }
}
