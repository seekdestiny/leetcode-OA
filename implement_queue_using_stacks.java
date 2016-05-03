/** using two stacks
 ** always push into stack1
 ** pop, top on stack2
 ** every time pop or top, if stack2 empty, move all items in stack1 into stack2 to make first element available
**/

class MyQueue {
    // Push element x to the back of queue.
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    
    private void dump() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }
    
    public MyQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }
    
    public void push(int x) {
        stack1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (stack2.isEmpty()) {
            dump();
        }
        
        stack2.pop();
    }

    // Get the front element.
    public int peek() {
        if (stack2.isEmpty()) {
            dump();
        }
        
        return stack2.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
