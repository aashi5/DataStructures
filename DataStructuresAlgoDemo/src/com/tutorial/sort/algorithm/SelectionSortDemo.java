package com.tutorial.sort.algorithm;

import com.tutorial.sort.algorithm.interfaces.SortingDemo;

/**
 * The Selection sort Algorithm iterates through the array to find the minimum element
 * and swaps the min element with the first element in the array in the first iteration. 
 * similarly the second element is replaced with the next smallest element 
 * in the next iteration and so on. 
 * 
 *  Time Complexity - Best, Worst , Avg - O(n^2)
 *  space Complexity - O(1) 
 * 
 * @author Ashwini
 *
 */
public class SelectionSortDemo  implements SortingDemo{

	public static void main(String[] args) {
		int[] arr = {3, 6, 1, 8, 4, 5};
		SelectionSortDemo demo = new SelectionSortDemo();
		demo.printArray(demo.sort(arr));
	}
	
	
	public int[] sort(int[] arr) {
		int minPosition=0;
		int temp;
		for(int i=0;i<arr.length;i++) {
			minPosition=i;
			for(int j=i+1;j<arr.length;j++) {
				// find the position of the smallest element in the subarray.
				if(arr[j] <arr[minPosition])
				//set j as new min position
					minPosition=j;
				
			}
			System.out.println("minPosition :" + minPosition);
			//swap the item in the min position with the 
			temp = arr[i];
			arr[i]=arr[minPosition];
			arr[minPosition]=temp;
			
		}
		return arr;
	}

	}
