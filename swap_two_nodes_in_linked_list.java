// pay attention to corner case
// node1 is just before node2

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param head a ListNode
     * @oaram v1 an integer
     * @param v2 an integer
     * @return a new head of singly-linked list
     */
    public ListNode swapNodes(ListNode head, int v1, int v2) {
        // Write your code here
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        ListNode node1Prev = null;
        ListNode node2Prev = null;
        
        while (head.next != null) {
            if (head.next.val == v1) {
                node1Prev = head;
            } else if (head.next.val == v2) {
                node2Prev = head;  
            }
            head = head.next;
        }
        
        if (node1Prev == null || node2Prev == null) {
            return dummy.next;
        }
        
        if (node2Prev.next == node1Prev) {
            ListNode t = node1Prev;
            node1Prev = node2Prev;
            node2Prev = t;
        }
        
        ListNode node1 = node1Prev.next;
        ListNode node2 = node2Prev.next;
        ListNode node2Next = node2.next;
        
        if (node1Prev.next == node2Prev) {
            node1Prev.next = node2;
            node1.next = node2.next;
            node2.next = node1;
        } else {
            node1Prev.next = node2;
            node2.next = node1.next;
            node2Prev.next = node1;
            node1.next = node2Next;
        }
        
        return dummy.next;
    }
}
