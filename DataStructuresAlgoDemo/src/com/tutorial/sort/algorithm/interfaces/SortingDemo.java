package com.tutorial.sort.algorithm.interfaces;

public interface SortingDemo {
	
	
	public default void printArray(int[] sortedArr) {
		
		// streams are not necessarily the fastest solution. like in this case while working with Arrays traditional loops are generally faster since arrays are index based. 
		// secondly our operation is not too complex which involves multiple piping or reducing functions so in this case traditional loops are faster. 
		for (int i = 0; i < sortedArr.length; i++) {
		System.out.println(sortedArr[i]); }
		
		
		// streaming over Arrays. 
		//Arrays.stream(sortedArr).forEach(System.out::println);

	}

	
	public int[] sort(int[] unsortedArr);

}
