package leetcode;
/* Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Notes:
You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
Update (2015-06-11):
The class name of the Java function had been updated to MyStack instead of Stack.
 * 
 * 
 * https://discuss.leetcode.com/topic/36189/java-solutions-about-three-ways-one-of-which-utilizes-one-queue-and-the-others-utilize-two-queues
 */
import java.util.*;
public class lc_225_implementStackUsingQueues {
	Queue<Integer> stack;
    
    // Constructor
    public lc_225_implementStackUsingQueues(){
        stack = new LinkedList<Integer>();
    }
    
    //Push element x onto stack.
    public void push(int x) {
        stack.offer(x);
        for (int i = 0; i < stack.size() - 1; i++){ //  < size() - 1
            stack.offer(stack.poll());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        stack.poll();
    }

    // Get the top element.
    public int top() {
        return stack.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return stack.isEmpty();
    }
}
