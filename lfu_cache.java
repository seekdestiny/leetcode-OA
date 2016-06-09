// key point is: when two nodes have the same frequency, we need to implement a lru mechanism

//First solution: scan all nodes to find least frequency, time complexity can be o(n)
class Node {
    private int key;
    private int value;
    private int frequency;
    
    public Node(int key, int value, int frequency) {
        this.key = key;
        this.value = value;
        this.frequency = frequency;
    }
    
    public int getValue() {
        return value;
    }
    
    public void setValue(int value) {
        this.value = value;
    }
    
    public int getFreq() {
        return frequency;
    }
    
    public void setFreq(int frequency) {
        this.frequency = frequency;
    }
}

public class LFUCache {
    private int capacity;
    private LinkedHashMap<Integer, Node> map;

    // @param capacity, an integer
    public LFUCache(int capacity) {
        // Write your code here
        this.capacity = capacity;
        map = new LinkedHashMap<Integer, Node>();
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        // Write your code here
        if (get(key) != -1) {
            map.get(key).setValue(value);
            return;
        }
        
        Node newNode = new Node(key, value, 0);

        if (map.size() == capacity) {
            int lfuKey = getLFUKey();
            map.remove(lfuKey);
        }
        
        map.put(key, newNode);
    }

    public int get(int key) {
        // Write your code here
        if (!map.containsKey(key)) {
            return -1;
        }
        
        Node target = map.get(key);
        target.setFreq(target.getFreq() + 1);
        //hybird with lru cache
        map.remove(key);
        map.put(key, target);
        return target.getValue();
    }
    
    private int getLFUKey() {
       int key = 0;
       int minFreq = Integer.MAX_VALUE;
       
       for (Map.Entry<Integer, Node> entry: map.entrySet()) {
           if (minFreq > entry.getValue().getFreq()) {
               key = entry.getKey();
               minFreq = entry.getValue().getFreq();
           }
       }
        
       return key;
    }
}

//Second solution: o(1) time complex
public class LFUCache {
    private class Node{
        int value;
        ArrayList<Integer> set;
        Node prev;
        Node next;
        public Node (int value ){
            this.value = value;
            this.set = new ArrayList<Integer> ();
            this.prev = null;
            this.next = null;
        }
    }
    
    private class item{
        int key;
        int value;
        Node parent ;
        public item(int key ,int value, Node parent){
            this.key = key ;
            this.value = value;
            this.parent  = parent;
        }
    }
    
    private HashMap<Integer, item> map;
    private  Node head,tail;
    private  int capacity; // @param capacity, an integer
    
    public LFUCache(int capacity) {
        // Write your code here
        this.capacity = capacity;
        this.map = new HashMap <Integer,item> ();
        this.head = new Node (0);
        this.tail = new Node(Integer.MAX_VALUE);
        head.next = tail;
        tail.prev = head;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        // Write your code here
        if (get(key) != -1 ) {
            map.get(key).value = value;
            return ;
        }
        if (map.size() == capacity ){
            getLFUitem();
        }

        Node newpar = head.next;
        if ( newpar.value != 1){
            newpar = getNewNode(1,head,newpar);
        }
        item curitem = new item(key,value,newpar);
        map.put(key,curitem);
        newpar.set.add(key);
        return;  
    }

    public int get(int key) {
        // Write your code here
        if (!map.containsKey(key)){
            return -1;
        }
        item cur = map.get(key);
        Node curpar = cur.parent;
        if (curpar.next.value == curpar.value + 1){
            cur.parent= curpar.next;
            cur.parent.set.add(key);
        }else{
            Node newpar =getNewNode(curpar.value + 1,curpar,curpar.next);
            cur.parent = newpar;
            newpar.set.add(key);
        }
        curpar.set.remove(new Integer(key));
        if(curpar.set.isEmpty()){
            deleteNode(curpar);
        }
        return cur.value;
    }
    
    private Node getNewNode (int value ,Node prev , Node next){
        Node temp = new Node(value);
        temp.prev = prev;
        temp.next = next;
        prev.next = temp;
        next.prev = temp;
        return temp;
    }
    
    private void deleteNode(Node temp){
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        return ;
    }

    private void getLFUitem(){
        Node temp = head.next;
        int LFUkey = temp.set.get(0);
        temp.set.remove(0);
        map.remove(LFUkey);
        if (temp.set.isEmpty()){
            deleteNode(temp);
        }
        return;
    }
}
