package datastructures;

public class Array_Stack_Implementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Array_Stack_Implementation stack = new Array_Stack_Implementation(5);
		
		stack.push(10);
		stack.push(16);
		stack.push(50);
		stack.push(40);
		stack.push(35);
		
		System.out.println(stack.isfull());
		System.out.println(stack.isempty());
		System.out.println(stack.peek());
	}
	
	
		private int max;
		int []stackarray;
		int top;
		public Array_Stack_Implementation (int max) {
			super();
			this.max = max;
			this.stackarray = new int[max];
			this.top=-1;
		}
		
		public void push(int data) {
			
			if (isfull()) {
				throw new RuntimeException("Stack is Full");
				
			}
			stackarray[++top]= data;
		}
		
		public int pop() {
			if (isempty()) {
				
				throw new RuntimeException("Stack is Empty");
				
			}
			
			return stackarray[top--];
		}
		
		public int peek() {
			
			if (isempty()) {
				
				throw new RuntimeException("Stack is Empty");
				
			}
			
			return stackarray[top];
		}
		
		public boolean isempty() {
			return top == -1;
		}
		
		public boolean isfull() {
			return max -1==top;
		}
	}


