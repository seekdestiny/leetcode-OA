/**
 * solution1: use min heap

 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>() {
        public int compare(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return 1;
            } else if (l2 == null) {
                return -1;
            } else {
                return l1.val - l2.val;
            }
        }
    };
     
    public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here
        if (lists == null || lists.size() == 0) {
            return null;
        }
        
        Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), ListNodeComparator);
        
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
                heap.add(lists.get(i));
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode track = dummy;
        
        while (!heap.isEmpty()) {
            ListNode temp = heap.poll();
            track.next = temp;
            track = track.next;
            if (temp.next != null) {
                heap.add(temp.next);
            }
        }
        
        return dummy.next;
    }
}
