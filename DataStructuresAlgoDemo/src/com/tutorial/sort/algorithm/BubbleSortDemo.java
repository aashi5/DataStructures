package com.tutorial.sort.algorithm;

import com.tutorial.sort.algorithm.interfaces.SortingDemo;

/**
 * Compares each element with the next element in the array and swaps if the
 * next element is higher.so after each complete pass of the array(inner loop)
 * the last positions of the array filled with the highest numbers moving
 * inwards. the enhanced version uses a flag to identify when there are no more
 * swaps happening which implies the array is already sorted
 * 
 * 
 * Time complexity - Worst case - O(n^2), best case O(n), Avg - O(n^2)
 * Space Complexity-O(1)
 * 
 * @author Ashwini
 *
 */
public class BubbleSortDemo implements SortingDemo{

	public static void main(String... args) {
		int[] arr = { 64, 34, 25, 12, 22, 11, 90 };
		BubbleSortDemo demo = new BubbleSortDemo();
		demo.printArray(demo.sort(arr));

		int[] newArr = { 90, 34, 25, 12, 22, 11, 64 };

		demo.printArray(demo.bubbleSortWithFlag(newArr));

	}

	
	/**
	 * Bubble sort with a flag which breaks out of the loop if no interchange is
	 * done for the entire iteration
	 * 
	 * @param arr
	 * @return
	 */
	public int[] bubbleSortWithFlag(int[] arr) {
		int temp = 0;
		int i;
		boolean isSorted = false; // flag will be set to true if no interchange happens for the entire iteration.
		// iterate n number of times where n = length of array.
		for (i = 0; i < arr.length; i++) {
			// repeatedly compare each element with its next element and interchange.
			isSorted = true;
			for (int j = 1; j < arr.length; j++) {
				if (arr[j - 1] > arr[j]) {
					// interchange the items if the arr at position i+1 is greater.
					temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
					isSorted = false;
				}
			}
			// break out of the loop if no interchange happens for an entire iteration.
			if (isSorted)
				break;
		}
		System.out.println("Number of Iterations : " + i);
		return arr;
	}


	/**
	 * original Bubble sort.
	 * 
	 * @param arr
	 * @return
	 */
	@Override
	public int[] sort(int[] arr) {
		int temp = 0;
		int i;
		// iterate n number of times where n = length of array.
		for (i = 0; i < arr.length; i++) {
			// repeatedly compare each element with its next element and interchange.
			for (int j = 1; j < arr.length - i - 1; j++) {
				if (arr[j - 1] > arr[j]) {
					// interchange the items if the arr at position i+1 is greater.
					temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				}
			}

		}
		System.out.println("Number of Iterations :" + i);
		return arr;
	}

}
