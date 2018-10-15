package leetcode_872;

import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    private void run() {
        Integer[] treeArr1 = {3,5,1,6,2,9,8,null,null,7,4};
        Integer[] treeArr2 = {3,5,1,6,7,4,2,null,null,null,null,null,null,9,8};
        LinkedList<TreeNode> treeNodeList1 = treeArrToTreeNodeList(treeArr1);
        LinkedList<TreeNode> treeNodeList2 = treeArrToTreeNodeList(treeArr2);
        System.out.println(leafSimilar(treeNodeList1.get(0), treeNodeList2.get(0)));

    }

    public LinkedList<TreeNode> treeArrToTreeNodeList(Integer[] treeArr) {
        LinkedList<TreeNode> treeNodeList = new LinkedList<>();
        for (int i = 0; i < treeArr.length; i++) {
            TreeNode treeNode = null;
            if (treeArr[i] != null) {
                treeNode = new TreeNode(treeArr[i]);

            }
            treeNodeList.add(treeNode);

            if (i == 0) {
                continue;
            }
            int parentIndex = (i - 1) / 2;
            if ((i - 1) % 2 == 0) {
                treeNodeList.get(parentIndex).left = treeNode;
            }
            else {
                treeNodeList.get(parentIndex).right = treeNode;
            }
        }
        return treeNodeList;
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        LinkedList<TreeNode> leaf1 = new LinkedList<>();
        LinkedList<TreeNode> leaf2 = new LinkedList<>();
        inOrder(root1, leaf1);
        inOrder(root2, leaf2);
        return compare(leaf1, leaf2);
    }

    public void inOrder(TreeNode node, LinkedList<TreeNode> leaf) {
        if (node == null) {
            return;
        }

        inOrder(node.left, leaf);
        if (node.left == null && node.right == null) {
            leaf.add(node);
        }
        inOrder(node.right, leaf);
    }

    public boolean compare(LinkedList<TreeNode> list1, LinkedList<TreeNode> list2) {
        if(list1.size() != list2.size()) {
            return false;
        }

        int length = list1.size();
        for(int i = 0; i < length; i++) {
            if(list1.get(i).val != list2.get(i).val) {
                return false;
            }
        }

        return true;
    }
}
