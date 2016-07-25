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
  public ListNode quickSort(ListNode head) {
    // write your solution here
    if (head == null || head.next == null) {
      return head;
    }
    ListNode[] res = sort(head);
    return res[0];
  }
  
  private ListNode[] sort(ListNode head) {
    ListNode[] res = new ListNode[]{head, head};
    
    if (head == null || head.next == null) {
      return res;
    }
    
    ListNode small = new ListNode(0);
    ListNode trackS = small;
    ListNode large = new ListNode(0);
    ListNode trackL = large;
    
    ListNode track = head.next;
    head.next = null;
    
    while (track != null) {
      if (track.value < head.value) {
        trackS.next = track;
        trackS = trackS.next;
      } else {
        trackL.next = track;
        trackL = trackL.next;
      }
      
      track = track.next;
    }
    trackS.next = null;
    trackL.next = null;
    
    ListNode[] left = sort(small.next);
    ListNode[] right = sort(large.next);
    
    if (left[1] != null) {
      left[1].next = head;
      res[0] = left[0];
    }
    
    if (right[0] != null) {
      head.next = right[0];
      res[1] = right[1];
    }
    
    return res;
  }
}
