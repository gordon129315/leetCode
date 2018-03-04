/*
https://leetcode.com/problems/merge-two-sorted-lists/description/
21. Merge Two Sorted Lists
 */

package leetcode_21;

public class Drive {
    public static void main(String[] args) {
        new Drive().run();
    }

    public void run() {
        SimpleList l1 = new SimpleList();
        l1.add(1);
        l1.add(2);
        l1.add(4);
        System.out.println(l1);

        SimpleList l2 = new SimpleList();
        l2.add(1);
        l2.add(3);
        l2.add(4);
        System.out.println(l2);


        ListNode node = mergeTwoLists(l1.head.next, l2.head.next);
        SimpleList list = new SimpleList(node);
        System.out.println(list);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode();
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val <= l2.val) {
            node = l1;
            node.next = mergeTwoLists(l1.next, l2);
        }
        else {
            node = l2;
            node.next = mergeTwoLists(l1, l2.next);
        }

        return node;
    }


}
