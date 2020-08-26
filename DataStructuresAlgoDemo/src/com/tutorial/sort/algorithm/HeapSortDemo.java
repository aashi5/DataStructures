package com.tutorial.sort.algorithm;

import com.tutorial.sort.algorithm.interfaces.SortingDemo;

/**
 * Heap sort is an inplace alogorithm (meaning it transforms the original input
 * and does'nt require any auxiliary data structure to accomplish sorting. may
 * need only a very small amount of extra storage.)
 * 
 * Time complexity - O(nlogn) for all cases.
 * https://www.programiz.com/dsa/heap-sort
 * Space Complexity = O(1)
 * @author Ashwini
 *
 */
public class HeapSortDemo implements SortingDemo {

	public static void main(String... args) {
		int[] arr = { 12, 11, 13, 5, 6, 7 };
		SortingDemo demo = new HeapSortDemo();
		demo.printArray(demo.sort(arr));

	}

	/**
	 * 
	 */
	@Override
	public int[] sort(int[] arr) {

		int length = arr.length; 
		// build max heap structure
		// we start with the mid element since it is the last node with children.
		// all others will be leaf nodes. 
		for (int i = length / 2 - 1; i >= 0; i--) {
			heapify(arr, length, i);
		}

		// exchange the root element with the last element and heapify again leaving out the last element. 
		for (int i = length - 1; i > 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapify(arr, i, 0);
		}
		return arr;
	}

	/**
	 * build the max heap structure such that element at 2i+1 will be the left child
	 * and element at 2*i+2 will be the right child.
	 * 
	 * @param arr
	 */
	private void heapify(int[] arr, int length, int i) {
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		int temp = 0;

		// if the left child is bigger than the root make it the largest
		if (left < length && arr[left] > arr[largest]) {

			largest = left;
		}
		// if the right child is bigger.
		if (right < length && arr[right] > arr[largest]) {
			largest = right;
		}
		if (largest != i) {
			// swap so the largest element now becomes the root.
			temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			// recursively heapify the affected sub arrays.
			heapify(arr, length, largest);
		}

	}

}
