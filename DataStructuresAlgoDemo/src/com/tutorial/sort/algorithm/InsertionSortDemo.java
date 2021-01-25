package com.tutorial.sort.algorithm;

import com.tutorial.sort.algorithm.interfaces.SortingDemo;

/**
 * In insertion sort each element in the unsorted element is compared with all
 * the elements before it. to find the greatest element smaller than the current
 * element. All greater elements are shifted to the right to place the current
 * element in its sorted place
 * 
 * Worst Case Time Complexity [ Big-O ]: O(n2) 
 * 
 * Best Case Time Complexity [Big-omega]: O(n)
 * 
 * Average Time Complexity [Big-theta]: O(n2)
 * 
 * @author Ashwini
 *
 */
public class InsertionSortDemo implements SortingDemo {

	public static void main(String[] args) {
		int[] arr = { 3, 6, 1, 8, 4, 5 };
		InsertionSortDemo demo = new InsertionSortDemo();
		demo.printArray(demo.sort(arr));

	}

	/**
	 * Sorting algorithm for Insertion Sort.
	 */
	@Override
	public int[] sort(int[] arr) {
		int temp;
		int j = 0;
		for (int i = 1; i < arr.length; i++) {
			temp = arr[i]; 
			j = i - 1;
			while (j >= 0 && arr[j] > temp) {
				// right shift the elements.
				arr[j + 1] = arr[j];
				j = j - 1;

			}
			
			arr[j + 1] = temp;
		}
		return arr;
	}

}
