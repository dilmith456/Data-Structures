package datastructures;

import java.util.ArrayDeque;
import java.util.Deque;
public class Deque_Stack_Implementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
			Deque<Integer> dq = new ArrayDeque<>();
			
			dq.add(3);
			dq.addLast(4);
			dq.addFirst(2);
			dq.addFirst(1);
			dq.addFirst(10);
			
			System.out.println("Deque Content " +  dq);
			System.out.println("Remove first Element: "+ dq.pollFirst());
			System.out.println("Deque Content " +  dq);
	}

}
