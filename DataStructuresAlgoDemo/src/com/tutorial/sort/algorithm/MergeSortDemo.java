package com.tutorial.sort.algorithm;

import com.tutorial.sort.algorithm.interfaces.SortingDemo;

/**
 * Recursively divide the unsorted array until each subarray contains only 
 * one element then merge the subarrays by comparing each of the elements of the subarrays 
 * to ensure sorted merging. 
 * subarrays to form a sorted result set.
 * Worst case, best case and avg case time complexity - O(nlog^n);
 * @author Ashwini
 *
 */
public class MergeSortDemo implements SortingDemo {


	public static void main(String[] args) {
		int[] arr = { 3, 6, 1, 8, 4, 5 };
		SortingDemo demo = new MergeSortDemo();
		demo.printArray(demo.sort(arr));

	}

	
	@Override
	public int[] sort(int[] unsortedArr) {
		// TODO Auto-generated method stub
		 mergeSort(unsortedArr, unsortedArr.length);
		 return unsortedArr;
	}

	/**
	 * 
	 * @param arr
	 * @param end
	 */
	private void mergeSort(int[] arr, int end) {
		// stop dividing if the subarray only has 1 element
		if(end<2) {
			return;
		}
		// else compute the new mid the initialize the size of the left and right array. 
		int mid = end/2;
		int[] leftArr=new int[mid];
		int[] rightArr=new int[end-mid];
		
		// populate the left array and right array based on mid 
		for(int i=0,j=0;i<end;i++) {
			if(i<mid) leftArr[i]=arr[i];// populate elements until mid to left array.
			else {
				rightArr[j]=arr[i]; // populate elements from mid+1 to the end to right array.
				j++;
			}
			
		}
		
		// further divide the sub-arrays. 
		mergeSort(leftArr,mid);
		mergeSort(rightArr, end-mid);
		
		// merge all the subarrays.
		merge(arr,leftArr,rightArr,mid,end-mid);
		
	}
	
	/**
	 * 	
	 * @param arr
	 * @param leftArr - left array
	 * @param rightArr- right array
	 * @param left - end position of left array
	 * @param right- end position of right array
	 */
	private void merge(int[] arr, int[] leftArr, int[] rightArr,int left, int right){
		// copy the contents of leftArr and rightArr to the correct position into array.
		int i=0,j=0,k=0;
		while(i<left && j<right) {
			if(leftArr[i]<rightArr[j]) {
				arr[k++]=leftArr[i++];
			}
			else {
				arr[k++]=rightArr[j++];
			}
		}
		//if there are still some elements left to be copied. 
		while(i<left) {
			arr[k++]=leftArr[i++];
			
		}
		
		while(j<right) {
			arr[k++]=rightArr[j++];
		}
		
	}
}
