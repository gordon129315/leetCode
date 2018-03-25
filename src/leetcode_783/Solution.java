/*
https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/
783. Minimum Distance Between BST Nodes
 */

package leetcode_783;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
        TreeNode n4 = new TreeNode(4);
        TreeNode n2 = new TreeNode(2);
        TreeNode n6 = new TreeNode(6);
        TreeNode n1 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        n4.setLeft(n2);
        n4.setRight(n6);
        n2.setLeft(n1);
        n2.setRight(n3);

        System.out.println(minDiffInBST(n4));

    }

    public int minDiffInBST(TreeNode root) {
        List<Integer> inOrderList = new ArrayList<>();
        inOrderTraverse(root, inOrderList);
        System.out.println(inOrderList);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < inOrderList.size(); i++) {
            minDiff = Math.min(minDiff, Math.abs(inOrderList.get(i) - inOrderList.get(i - 1)));
        }
        return minDiff;
    }

    private void inOrderTraverse(TreeNode root, List<Integer> inOrderList) {
        if (root == null) {
            return;
        }
        inOrderTraverse(root.left, inOrderList);
        inOrderList.add(root.val);
        inOrderTraverse(root.right, inOrderList);
    }

}
