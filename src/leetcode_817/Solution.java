/*
https://leetcode.com/problems/linked-list-components/description/
817. Linked List Components
 */

package leetcode_817;


public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
        ListNode head = new ListNode(0);
        int[] nodes = {1, 2, 3};
        add(head, nodes);
        int[] G = {0, 1, 3};
        System.out.println(numComponents(head, G));

    }

    private void add(ListNode node, int[] nodes) {
        for (int value : nodes) {
           node.next = new ListNode(value);
           node = node.next;
        }
    }

    public int numComponents(ListNode head, int[] G) {
        if (head == null || G.length == 0) {
            return 0;
        }

        ListNode node = head;
        int count = 0;
        int temp = 0;
        do {
            if (!contain(G, node.val)) {
                if (temp != 0) {
                    count++;
                    temp = 0;
                }

            }
            else {
                temp++;
            }

        node = node.next;
        }while (node != null);

        if (temp == 0) {
            return count;
        }
        else {
            return count + 1;
        }

    }

    private boolean contain(int[] G, int val) {
        for (int i : G) {
            if (i == val) {
                return true;
            }
        }
        return false;
    }


}
