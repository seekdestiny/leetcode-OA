/** very very very important!
 * use double linkedlist to track visit history
 * head is the least recent item
 * use hashmap to store key<->listnode
 * twp dummy node is used
**/

class ListNode {
    int key;
    int value;
    ListNode prev;
    ListNode next;
    public ListNode(int key, int value) {
       this.key = key;
       this.value = value;
    }
}

public class LRUCache {
    int capacity;
    Map<Integer, ListNode> record;
    ListNode head;
    ListNode tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        record = new HashMap<>();
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!record.containsKey(key)) {
            return -1;
        }
        
        ListNode current = record.get(key);
        current.prev.next = current.next;
        current.next.prev = current.prev;
        
        move_to_tail(current);
        
        return record.get(key).value;
    }
    
    public void set(int key, int value) {
        if (get(key) != -1) {
            record.get(key).value = value;
            return;
        }
        
        if (record.size() == capacity) {
            record.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        
        ListNode newNode = new ListNode(key, value);
        move_to_tail(newNode);
        record.put(key, newNode);
    }
    
    private void move_to_tail(ListNode current) {
        current.prev = tail.prev;
        current.next = tail;
        current.prev.next = current;
        tail.prev = current;
    }
}
