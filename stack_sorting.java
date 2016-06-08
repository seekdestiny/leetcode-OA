//similar to tower of hanoi

public class Solution {
    /**
     * @param stack an integer stack
     * @return void
     */
    public void stackSorting(Stack<Integer> stack) {
        // Write your code here
        Stack<Integer> another = new Stack<Integer>();
        
        while (!stack.isEmpty()) {
            if (another.isEmpty()) {
                another.add(stack.pop());
            } else {
                if (stack.peek() <= another.peek()) {
                    another.add(stack.pop());
                } else {
                    int temp = stack.pop();
                    
                    while (!another.isEmpty() && another.peek() < temp) {// do not forget to check empty another
                        stack.add(another.pop());
                    }
                    
                    another.add(temp);
                }
            }
        }
        
        while (!another.isEmpty()) {
            stack.add(another.pop());
        }
    }
}
