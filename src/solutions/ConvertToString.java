package src.solutions;

import src.ListNode;

import java.math.BigInteger;

public class ConvertToString implements Solution {
    @Override
    public ListNode solve(ListNode l1, ListNode l2) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        while(l1 != null) {
            s1.insert(0, l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            s2.insert(0, l2.val);
            l2 = l2.next;
        }
        BigInteger i1 = new BigInteger(s1.toString());
        BigInteger i2 = new BigInteger(s2.toString());
        BigInteger iResult = i1.add(i2);
        String sResult = iResult.toString();

        String digit = sResult.substring(0, 1);
        sResult = sResult.substring(1);
        ListNode previousNode = new ListNode(Integer.parseInt(digit));
        ListNode currentNode = previousNode;
        while(sResult.length() > 0) {
            digit = sResult.substring(0, 1);
            sResult = sResult.substring(1);
            currentNode = new ListNode(Integer.parseInt(digit));
            currentNode.next = previousNode;
            previousNode = currentNode;
        }
        return currentNode;
    }
}
