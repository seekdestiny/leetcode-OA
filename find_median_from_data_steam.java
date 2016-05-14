/** maintain two heap
**/

class MedianFinder {

    Queue<Integer> maxheap = new PriorityQueue<Integer>(Collections.reverseOrder());
    Queue<Integer> minheap = new PriorityQueue<Integer>();

    // Adds a number into the data structure.
    public void addNum(int num) {
        if (maxheap.isEmpty()) {
            maxheap.add(num);
        } else {
            if (num < maxheap.peek()) {
                maxheap.add(num);
            } else {
                minheap.add(num);
            }
        }
        
        if (maxheap.size() - minheap.size() > 1) {
            minheap.add(maxheap.poll());
        }
        
        if(minheap.size() > maxheap.size()) {
            maxheap.add(minheap.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (maxheap.size() == minheap.size()){
            return ((maxheap.peek() + minheap.peek()) / 2.0);
        } else {
            return maxheap.peek();   
        }
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
