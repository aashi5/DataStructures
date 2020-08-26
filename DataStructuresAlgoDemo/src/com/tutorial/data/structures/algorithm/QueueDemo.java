package com.tutorial.data.structures.algorithm;

/**
 * Insertion happens at the Rear(tail) and deletion happens from the Front(Head)
 * following the FIFO. Applications - serving requests on a single shared
 * resource handling of interrupts in real time scenarios.
 * 
 * @author Ashwini
 *
 */
public class QueueDemo {

	public static void main(String... args) {
		Queue queue = new Queue(new int[4]);

		queue.enqueue(5);
		queue.enqueue(8);
		queue.enqueue(9);
		queue.enqueue(7);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());

	}
}

class Queue {

	int head;
	int tail;
	int[] queue;

	Queue(int[] queue) {
		this.tail = 0;
		this.head = 0;
		this.queue = queue;
	}

	/**
	 * 
	 * @return
	 */
	public int peek() {

		return queue[head];
	}

	/**
	 * Add an element to the queue if its not already full.
	 * 
	 * @param value
	 */
	public void enqueue(int value) {
		if (tail < queue.length)
			queue[tail++] = value;
		else
			System.out.println("Queue is full. Cannot add more elements");
	}

	/**
	 * Dequeue method removes the element from the head of the array and shifts the
	 * position of the head to the next element.This is will leave blank spaces in
	 * the beginning which will reduce the overall size of the array. Instead of
	 * fixing the position of the array on every dequeue operation we can resize
	 * only when the head is one position before the end of array.
	 * 
	 * @return
	 */
	public int dequeue() {
		if (head == -1) {
			System.out.println("No Element in the queue.");
			return -1;
		} else {
			int value = queue[head++];
		
			if (tail > queue.length - 1 && head > 0) {
				System.out.println("Before positioning : tail :" + tail + " head: " + head);
				// shift the elements starting from the head to the tail to the beginning of the
				// array.
				int i = 0, j = 0;
				for (i = head, j = 0; i < tail; i++, j++) {
					queue[j] = queue[i];
					queue[i] = 0;
				}
				head = 0;	tail = j;
				System.out.println("After positioning  tail :" + tail + " head: " + head);

			}

			return value;
		}
	}

}