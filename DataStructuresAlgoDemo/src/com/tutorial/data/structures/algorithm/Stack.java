package com.tutorial.data.structures.algorithm;

/**
 * FILO order. -- First in Last out. Every time an element is added to the top and 
 * removed from the top.
 * Ordered List 
 * Applications - Reversing a letter , parsing , expression conversion.
 * Push, Pop and Top operation - O(1) , search Operation - O(n)
 * @author Ashwini
 *
 */
 class StackDemo {

	public static void main(String ...args) {
		//int[] array= {1,3,5};
		Stack stack= new Stack( new int[3]);
		System.out.println(stack.pop());
		stack.push(6);
		stack.push(3);
		stack.push(5);
		stack.push(70);
		System.out.println("Last Element : "+stack.pop());
	}
	
}

public class Stack{
	int top;
	int[] stackArr;
	
	public Stack(int[] stackArr){
		this.top=-1;
		this.stackArr=stackArr;
		
	}
	public int pop() {
		if(top ==-1) {
			System.out.println("No Elements to remove");
			return -1;
		}
	return stackArr[top--];
	}
	
	public void push(int n) {
		if(top==stackArr.length-1) {
			System.out.println("Stack is already full");
			return;
		}
	
		stackArr[++top]=n;
	}
	
	
}