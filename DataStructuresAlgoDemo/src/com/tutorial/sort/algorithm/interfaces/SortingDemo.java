package com.tutorial.sort.algorithm.interfaces;

public interface SortingDemo {
	
	
	public default void printArray(int[] sortedArr) {
		for (int i = 0; i < sortedArr.length; i++) {
			System.out.println(sortedArr[i]);
		}

	}

	
	public int[] sort(int[] unsortedArr);

}
