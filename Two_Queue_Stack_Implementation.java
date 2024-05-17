package datastructures;

import java.util.LinkedList;
import java.util.Queue;

public class Two_Queue_Stack_Implementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Two_Queue_Stack_Implementation stack = new Two_Queue_Stack_Implementation();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top element: " + stack.top()); // Output: 3
        System.out.println("Popped element: " + stack.pop()); // Output: 3
        System.out.println("Top element: " + stack.top()); // Output: 2
        System.out.println("Is stack empty? " + stack.isEmpty()); // Output: false

        stack.pop();
        stack.pop();

        System.out.println("Is stack empty? " + stack.isEmpty()); // Output: true
	}
	

	    Queue<Integer> q1;
	    Queue<Integer> q2;

	    public Two_Queue_Stack_Implementation() {
	        q1 = new LinkedList<>();
	        q2 = new LinkedList<>();
	    }
	    public void push(int x) {
	        q2.offer(x);
	        while (!q1.isEmpty()) {
	            q2.offer(q1.poll());
	        }
	        // Swap q1 and q2
	        Queue<Integer> temp = q1;
	        q1 = q2;
	        q2 = temp;
	    }
	    public int pop() {
	        if (isEmpty()) {
	            throw new IllegalStateException("Stack is empty");
	        }
	        return q1.poll();
	    }
	    public int top() {
	        if (isEmpty()) {
	            throw new IllegalStateException("Stack is empty");
	        }
	        return q1.peek();
	    }
	    public boolean isEmpty() {
	        return q1.isEmpty();
	    }
	}
	    
	


