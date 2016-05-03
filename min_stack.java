/** 依然使用两个栈实现
 ** 第一个普通， 第二个的head 记录当前最小值
 ** push: 新值比当前最小还小，进第二个栈
 ** pop: 出栈的是当前最小值，第二个栈也出栈
**/

public class MinStack {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    /** initialize your data structure here. */
    public MinStack() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }
    
    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty() || x <= stack2.peek()) {
            stack2.push(x);
        }
    }
    
    public void pop() {
        int res = stack1.pop();
        if (res == stack2.peek()) {
            stack2.pop();
        }
    }
    
    public int top() {
        return stack1.peek();
    }
    
    public int getMin() {
        return stack2.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
 
 /** 
 ** advanced solution
 ** 利用存一个有关min 的对称数来复原旧的min
**/
public class MinStack {
    Stack<Integer> stack;
    int min;
    
    public MinStack() {
        // do initialize if necessary
        stack = new Stack<Integer>();
        min = 0;
    }

    public void push(int number) {
        // write your code here
        if (stack.isEmpty()) {
            stack.push(number);
            min = number;
        } else if (number < min) {
            stack.push(2 * number - min);
            min = number;
        } else {
            stack.push(number);
        }
    }

    public int pop() {
        // write your code here
        int number = stack.pop();
        if (number < min) {
            int prevMin = min;
            min = 2 * min - number;
            return prevMin;
        } else {
            return number;
        }
    }

    public int min() {
        // write your code here
        return min;
    }
}
