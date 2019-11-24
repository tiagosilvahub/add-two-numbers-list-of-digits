package src;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    boolean equals(ListNode l1) {
        if(next == null && l1.next != null ||
                next != null && l1.next == null)
            return false;
        return val == l1.val && (next == null || next.equals(l1.next));
    }

    public String toString() {
        return val + (next == null ? "" : next.toString());
    }
}