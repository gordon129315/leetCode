package leetcode_21;

public class SimpleList {
    public ListNode head;
    public ListNode last;

    public SimpleList() {
        head = new ListNode();
        last = head;
    }

    public SimpleList(ListNode node) {
        this.head = node;
        last = head;
    }

    public void add(int i) {
        last.next = new ListNode(i);
        last = last.next;
    }

    @Override
    public String toString() {
        if (this == null) {
            return "[]";
        }

        String str = "[";
        ListNode node = head;
        while (node.next != null){
            node = node.next;
            str += node.val + ",";
        }
        if (str.lastIndexOf(",") != -1) {
            str = str.substring(0, str.lastIndexOf(","));
        }
        str += "]";
        return str;
    }
}
