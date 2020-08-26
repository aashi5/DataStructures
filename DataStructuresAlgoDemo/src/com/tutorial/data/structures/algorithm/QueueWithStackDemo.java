package com.tutorial.data.structures.algorithm;
/**
 * Implementation of a Queue using a stack as an underlying data structure instead 
 * of a simple array.
 * since stack uses the LIFO principle we need to adjust our enqueue or dequeue method
 * to ensure that the first element inserted is the one popped out first.
 * The following example demonstrates the adjusted dequeue method to ensure this sequence.
 * 
 * @author Ashwini
 *
 */
public class QueueWithStackDemo {

	public static void main(String... args) {
		
		QueueWithStack queue=new QueueWithStack(new int[4]);
		queue.enqueue(5);
		queue.enqueue(8);
		queue.enqueue(9);
		queue.enqueue(7);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		
	}
}

class QueueWithStack {

	Stack stack;
	//temp queue temporarily holds the other elements while retrieving the first element.
	Stack tempQueue;
	
	public QueueWithStack(int[] stack) {
		this.stack=new Stack(stack);
	}

	public void enqueue(int value) {

		stack.push(value);

	}

	public int dequeue() {
		int[] stackArr = new int[this.stack.top];
		tempQueue=new Stack(stackArr);
		int value=0;
		// create a temp queue to store the top elements and remove the first element
		// added in the stack
		while(stack.top>0) {
			tempQueue.push(stack.pop());
		}
		value=stack.pop();
		while(tempQueue.top>0) {
			stack.push(tempQueue.pop());
		}
		return value;
	}
}
