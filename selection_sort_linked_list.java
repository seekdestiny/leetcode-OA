/**
 * class ListNode {
 *   public int value;
 *   public ListNode next;
 *   public ListNode(int value) {
 *     this.value = value;
 *     next = null;
 *   }
 * }
 */
public class Solution {
  public ListNode selectionSort(ListNode head) {
    // Write your solution here.
    if (head == null || head.next == null) {
      return head;
    }
    
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode track = dummy;
    
    while (track.next != null) {
      head = track;
      ListNode min = track;
      while (head.next != null) {
        if (head.next.value < min.next.value) {
          min = head;
        }
        head = head.next;
      }
      
      if (min == track) {
        track = track.next;
      } else {
        ListNode target = min.next;
        min.next = target.next;
        target.next = track.next;
        track.next = target;
        track = track.next;
      }
    }
    
    return dummy.next;
  }
}
