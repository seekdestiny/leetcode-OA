/**
 * min heap use
**/

public class Solution {
    class Element {
        int value;
        int count;
        
        public Element(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }
    
    private Comparator<Element> ElementComparator = new Comparator<Element>() {
        public int compare(Element e1, Element e2) {
            return e1.count - e2.count;
        }
    };
    
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<Integer>();
        
        if (nums == null || nums.length == 0 || k == 0) {
            return res;
        }
        
        HashMap<Integer, Integer> record = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (record.containsKey(nums[i])) {
                record.put(nums[i], record.get(nums[i]) + 1);
            } else {
                record.put(nums[i], 1);
            }
        }
        
        Queue<Element> heap = new PriorityQueue<Element>(nums.length, ElementComparator);
        
        for (int item: record.keySet()) {
            if (heap.size() < k) {
                heap.add(new Element(item, record.get(item)));
            } else {
                Element peak = heap.peek();
                Element entry = new Element(item, record.get(item));
                if (ElementComparator.compare(peak, entry) < 0) {
                    heap.poll();
                    heap.add(entry);
                }
            }
        }
        
        while (!heap.isEmpty()) {
            res.add(0, heap.poll().value);
        }
        
        return res;
    }
}
