package com.tutorial.sort.algorithm;

import com.tutorial.sort.algorithm.interfaces.SortingDemo;

/**
 * Is an unstable sorting algorithm based on the divide and conquer rule using a
 * pivot element. The array is recursively divided into subarrays of elements
 * lesser than and greater than the pivot. Time Complexity Worst Case -O(n^2)
 * Avg and best case - O(nlog n), space Complexity-O(n*log n)
 * 
 * @author Ashwini
 *
 */
public class QuickSortDemo implements SortingDemo {

	public static void main(String[] args) {
		int[] arr = { 3, 6, 1, 8, 4, 5 };
		QuickSortDemo demo = new QuickSortDemo();
		demo.printArray(demo.sort(arr));

	}

	@Override
	public int[] sort(int[] arr) {
		int start = 0, end = arr.length - 1;
		quickSort(arr, start, end);
		return arr;
	}

	/**
	 * Partition the arrays into sub-arrays repeatedly and divide into subarrays.
	 * 
	 * @param arr
	 * @param start
	 * @param end
	 */
	private void quickSort(int[] arr, int start, int end) {
		// create partitions based on pivot element.
		int partition = partition(arr, start, end);
		if (partition - 1 > start) {
			quickSort(arr, start, partition - 1);
		}
		if (partition + 1 < end) {
			quickSort(arr, partition + 1, end);
		}

	}

	/**
	 * partition method is used to calculate the new position of the pivot element
	 * calculate such that all elements lesser than the pivot will be before it and
	 * all elements greater will be after.
	 * 
	 * @param arr
	 * @param start
	 * @param end
	 * @return - the new position of the pivot/
	 */
	private int partition(int[] arr, int start, int end) {
		int pivot = arr[end];
		int temp = 0;
		for (int i = start; i < end; i++) {
			// swap the element with the smallest available position and increment the start
			// position.
			if (arr[i] < pivot) {
				temp = arr[start];
				arr[start] = arr[i];
				arr[i] = temp;
				start++;// increment the partition pos.
			}
		}

		temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
		// start is the position indicating the division of the arrays such that left
		// partition has elements less than the pivot and the right partition has
		// elements greater than the pivot.
		return start;
	}

}
