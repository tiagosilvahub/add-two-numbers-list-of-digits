# add-two-numbers-list-of-digits
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

https://leetcode.com/problems/add-two-numbers/

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
```
Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807
```

Convert to string, then to BigInteger, add, convert back to ListNode:
```
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
```

Iterate over the list, sum values and calculate carry-on - adding a node at the end if needed due to carry-on.
```
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
```
