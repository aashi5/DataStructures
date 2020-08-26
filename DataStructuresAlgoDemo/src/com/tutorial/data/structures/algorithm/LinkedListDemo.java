package com.tutorial.data.structures.algorithm;

/**
 * Each node has its own value and a reference to the next node in sequence. use
 * for implementations of tree and graphs,stack, queues.
 * 
 * @author Ashwini
 *
 */
public class LinkedListDemo {

	public static void main(String ...args) {
		SingleLinkedList sLList= new SingleLinkedList();
		sLList.addNodeToEnd(3);
		sLList.addNodeToEnd(4);
		sLList.addNodeToEnd(6);
		sLList.addNodeToFront(9);
		sLList.printList();
		
		String result = sLList.deleteValueNode(4)?"Node Deleted ":"Node not deleted";
		System.out.println(result);
		sLList.printList();
		
		result = sLList.deleteValueNode(9)?"Node Deleted ":"Node not deleted";
		System.out.println(result);
		sLList.printList();
	
		result = sLList.deleteValueNode(6)?"Node Deleted ":"Node not deleted";
		System.out.println(result);
		sLList.printList();
		
		
		
	}
}

/**
 * Head points to the first element of the 
 * list which has pointer to the next node in line.
 * @author Ashwini
 *
 */
class SingleLinkedList {

	Node head;

	SingleLinkedList() {
		head = null;
	}

	class Node {
		private int data;
		private Node next;

		Node(int value) {
			this.data = value;
			this.next = null;
		}
	}

	/**
	 * Add a node to the end of the last node. 
	 * The entire list is iterated to find
	 * the last node.
	 * time Complexity - O(n) since we need to iterate to the last node.
	 * @param value- the value of the new node.
	 */
	public void addNodeToEnd(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			head = newNode;
		} else {
			// find the last node to add the current node to.
			Node lastNode = findLastNode();
			lastNode.next = newNode;
		}

	}

	/**
	 * The node is added to the beginning.
	 * Time Complexity - O(1)
	 */
	public void addNodeToFront(int value) {
		Node newNode = new Node(value);
		Node prevNode = head;
		// make the new value the new Head of the linked list and assign the old head as
		// the next value
		head = newNode;
		head.next = prevNode;
	}

	/**
	 * find the last node - O(n)
	 * @return
	 */
	public Node findLastNode() {
		Node lastNode = head;
		while (lastNode.next != null) {
			lastNode = lastNode.next;
		}
		return lastNode;
	}
	
	/**
	 * Print out the values of all the nodes in the list.
	 */
	public void printList() {
		Node nextNode= this.head;
		
		while(nextNode!=null) {
			System.out.println(nextNode.data);
			nextNode=nextNode.next;
		}
	}
	
	/**
	 * Search for the node with the given value and delete it. 
	 * O(n)
	 * @param value - delete node with the given value
	 * @return
	 */
	public boolean deleteValueNode(int value) {
		boolean nodeFound=false;
		if(head.data==value) {
			head = head.next;
			return true;
		}
		Node curNode = head;
		
		while(curNode.next!=null) {
			Node nextNode=curNode.next;
			if(nextNode.data==value) {
				curNode.next=nextNode.next;
				nodeFound=true;
				break;
			}
			curNode= curNode.next;
		}
		return nodeFound;
	}
	
	
}