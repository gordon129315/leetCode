/*
https://leetcode.com/problems/binary-tree-pruning/description/
814. Binary Tree Pruning
 */

package leetcode_814;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(0);
        TreeNode n2 = new TreeNode(0);
        TreeNode n3 = new TreeNode(1);

        root.left = null;
        root.right = n1;
        n1.left = n2;
        n1.right = n3;

        TreeNode treeNode = pruneTree(root);

        System.out.println();
    }

    public TreeNode pruneTree(TreeNode root) {
        preOrder(root);
        return root;
    }

    private void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
//        else if (node.val == 0 && node.left == null && node.right == null) {
//            node.val = 4;
//            return;
//        }

        System.out.println(node.val);

        if (node.left != null && isRemoved(node.left)){
            node.left = null;
        }
        preOrder(node.left);

        if (node.right != null && isRemoved(node.right)){
            node.right = null;
        }
        preOrder(node.right);

        if (node.left != null && isRemoved(node.left)){
            node.left = null;
        }
        if (node.right != null && isRemoved(node.right)){
            node.right = null;
        }

    }

    private boolean isRemoved(TreeNode node) {
        return (node.val == 0)
                && (node.left == null)
                && (node.right == null);
    }

}
