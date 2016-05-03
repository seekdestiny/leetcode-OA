/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        if (hashTable == null) {
            return null;
        }
        
        if (hashTable.length == 0) {
            return new ListNode[2];
        }
        
        int size = hashTable.length;
        int dsize = size * 2;
        ListNode[] res = new ListNode[dsize];
        
        for (int i = 0; i < hashTable.length; i++) {
            ListNode head = hashTable[i];
            
            while (head != null) {
                ListNode temp = head;
                head = head.next;
                temp.next = null;
                int index = temp.val >= 0 ? temp.val % dsize : (temp.val % dsize + dsize) % dsize;
                insert(res, index, temp);
            }
        }
        
        return res;
    }
    
    private void insert(ListNode[] res, int index, ListNode temp) {
        if (res[index] == null) {
            res[index] = temp;
            return;
        }
        
        ListNode head = res[index];
        while (head.next != null) {
            head = head.next;
        }
        
        head.next = temp;
    }
};
