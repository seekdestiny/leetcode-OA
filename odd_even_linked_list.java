/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummyOdd = new ListNode(0);
        ListNode dummyEven = new ListNode(0);
        
        dummyOdd.next = head;
        dummyEven.next = head.next;
        
        ListNode trackOdd = dummyOdd.next;
        ListNode trackEven = dummyEven.next;
        
        while (trackEven != null && trackEven.next != null) {
            trackOdd.next = trackEven.next;
            trackOdd = trackOdd.next;
            trackEven.next = trackOdd.next;
            trackEven = trackEven.next;
        }
        
        trackOdd.next = dummyEven.next;
        return dummyOdd.next;
    }
}
