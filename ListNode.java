public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

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