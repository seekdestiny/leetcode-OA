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
