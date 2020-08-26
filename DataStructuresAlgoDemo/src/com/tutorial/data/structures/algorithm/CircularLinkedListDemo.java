package com.tutorial.data.structures.algorithm;

/**
 * All the running applications in our computers 
 * are kept in a circular linked list and the OS
 * gives a fixed time slot to all for running. The Operating System keeps on
 * iterating over the linked list until all the applications are completed.
 * Multiplayer games.
 * @author Ashwini
 *
 */
public class CircularLinkedListDemo {
	
	public static void main(String ...strings) {
		CicularLinkedList cLinkedList = new CicularLinkedList();
		cLinkedList.addNodeToEnd(10);
		cLinkedList.addNodeToEnd(6);

		cLinkedList.addNodeToEnd(9);
		
		cLinkedList.addNodeToEnd(4);
		cLinkedList.addNodeToStart(7);
		System.out.println("Deleted from : " + cLinkedList.deleteNode(4));

		cLinkedList.printList();
		
	}

}

/**
 * The only difference from the regular Linked List is that the last node has a
 * pointer to the first Node.
 * 
 * 
 * @author Ashwini
 *
 */
class CicularLinkedList {

	// head points to first node and tail.next points to head. 
	private Node head;
	private Node tail;

	class Node {
		int data;
		Node next;

		/**
		 * Constructor to create a new Node.
		 * 
		 * @param data
		 */
		public Node(int data) {
			this.data = data;
			this.next = null;
		}

	}
	
	/**
	 * Check if the linked list is empty
	 * @return
	 */
	public boolean isEmpty() {
		return head==null? true:false;
		
	}
	/**
	 * add new node to the end of the last node.
	 * 
	 * @param value - value of the new node.
	 * @return position- position where the node is added.
	 */
	public int addNodeToEnd(int value) {
		int pos=1;
		Node node = new Node(value);
		if (head == null) {
			head = node;
		}else {
			tail.next = node;
		}
		tail = node;
		tail.next=head;
			
		return pos;
	}
	
	/**
	 * If adding node to the beginning of the circular lined list
	 * head is changed to point to the new node and the tail.next is also updated.
	 * @param value
	 */
	public void addNodeToStart(int value) {
		Node node = new Node(value);
		if(head == null) {
			tail=node;
		}else {
			node.next=head;
			tail.next=node;
		}
		
		head=node;
	}
	/**
	 * find first node with given value and delete its reference
	 * return the position from where the value was deleted. 
	 * @param value
	 */
	public int deleteNode(int value) {
		
		if(head.data==value) {			
			head =head.next;
			tail.next=head;
			System.out.println("Deleting Head.");
			return 0;
		}

		Node currNode =head;
		
		int position =1;
		do {
			if(currNode.next.data==value) {
				Node nextNode = currNode.next;
				if(tail==nextNode) {
					System.out.println("Deleting tail");
					tail=currNode;
					tail.next=head;
				}
				currNode.next =nextNode.next;
			
				return position;
			}
			currNode=currNode.next;
			position++;
			
		}while(!currNode.equals(tail.next));
		return -1;
	}
	/**
	 * Find the last node. 
	 * The last node is the one that is pointed by tail.
	 * @return
	 */
	public Node findLastNode() {
		return tail;
	}

	
	public void printList() {
		Node currNode= head;
		if(head==tail) {
			System.out.println(currNode.data);
		}else {
			do {
				System.out.println(currNode.data);
				currNode= currNode.next;
			}while(!currNode.equals(tail.next));
		}
	}

}