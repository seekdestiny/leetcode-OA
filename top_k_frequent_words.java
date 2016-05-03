/**
 ** use hashmap to record the frequency of words
 ** use min heap to store top k
 ** pay attention to string.compareTO order
**/

public class Solution {
    /**
     * @param words an array of string
     * @param k an integer
     * @return an array of string
     */
    class Element {
        String word;
        int count;
        
        public Element(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
    
    private Comparator<Element> ElementComparator = new Comparator<Element>() {
        public int compare(Element e1, Element e2) {
            if (e1.count > e2.count) {
                return 1;
            } else if (e1.count < e2.count) {
                return -1;
            } else {
                return e2.word.compareTo(e1.word);
            }
        }
    };
     
    public String[] topKFrequentWords(String[] words, int k) {
        // Write your code here
        if (words == null || words.length == 0) {
            return null;
        }
        
        if (k == 0) {
            return new String[0];
        }
        
        HashMap<String, Integer> count = new HashMap<String, Integer>();
        
        for (int i = 0; i < words.length; i++) {
            if (count.containsKey(words[i])) {
                int index = count.get(words[i]);
                index++;
                count.put(words[i], index);
            } else {
                count.put(words[i], 1);
            }
        }
        
        Queue<Element> heap = new PriorityQueue<Element>(words.length, ElementComparator);
        
        for (String item: count.keySet()) {
            Element peak = heap.peek();
            Element entry = new Element(item, count.get(item));
            
            if (heap.size() < k ) {
                heap.add(entry);
            } else {
                if (ElementComparator.compare(peak, entry) < 0) {
                    heap.poll();
                    heap.add(entry);
                }
            }
        }
        
        String[] res = new String[k];
        
        int idx = k - 1;
        while (!heap.isEmpty()) {
            res[idx--] = heap.poll().word;
        }
        
        return res;
    }
}
