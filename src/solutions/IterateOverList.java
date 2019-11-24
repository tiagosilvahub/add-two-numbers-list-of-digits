package src.solutions;

import src.ListNode;

public class IterateOverList implements Solution {

    @Override
    public ListNode solve(ListNode l1, ListNode l2) {
        int sum;
        int carryOn = 0;
        ListNode newNode;
        ListNode previousNode = null;
        ListNode parentNode = null;
        while (l1 != null || l2 != null || carryOn != 0) {
            sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carryOn;
            newNode = new ListNode(sum % 10);
            carryOn = sum / 10;

            if(parentNode == null) {
                parentNode = newNode;
            }

            if(previousNode != null) {
                previousNode.next = newNode;
            }
            previousNode = newNode;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        return parentNode;
    }
}
