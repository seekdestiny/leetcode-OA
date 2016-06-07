//always use 2nd q to hold n - 1 item in ist q so that we can touch the top item
// swap q to maintain the relation between 1st and 2nd q.

class Stack {
    Queue<Integer> firstQ = new LinkedList<Integer>();
    Queue<Integer> secondQ = new LinkedList<Integer>();
    
    // Push a new item into the stack
    public void push(int x) {
        // Write your code here
        firstQ.add(x);
    }

    // Pop the top of the stack
    public void pop() {
        // Write your code here
        while (firstQ.size() > 1) {
            secondQ.add(firstQ.poll());
        }
        
        firstQ.poll();
        swapQ();
    }

    // Return the top of the stack
    public int top() {
        // Write your code here
        while (firstQ.size() > 1) {
            secondQ.add(firstQ.poll());
        }
        
        int res = firstQ.peek();
        secondQ.add(firstQ.poll());
        swapQ();
        return res;
    }

    // Check the stack is empty or not.
    public boolean isEmpty() {
        // Write your code here
        return firstQ.isEmpty();
    }   
    
    public void swapQ() {
        Queue<Integer> temp = firstQ;
        firstQ = secondQ;
        secondQ = temp;
    }
}
