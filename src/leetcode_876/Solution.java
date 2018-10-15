// https://leetcode.com/problems/middle-of-the-linked-list/description/
// 876.Middle of the Linked List

package leetcode_876;

public class Solution {
    public ListNode middleNode1(ListNode head) {
        int size = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            size ++;
        }

        int middle = size / 2;
        node = head;
        for (int i = 0; i < middle; i++) {
            node = node.next;
        }

        return node;
    }

    public ListNode middleNode(ListNode head) {
        ListNode node = head, middle = head;

        while (node != null && node.next != null) {
            middle = middle.next;
            node = node.next.next;
        }

        return middle;
    }
}
