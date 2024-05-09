package datastructures;

import java.util.Arrays;

public class Optimized_Bubblesort {

	public static void main(String[] args) {
		
		 int[] array = {64, 34, 25, 12, 22, 11, 90};
	        System.out.println("Original array: " + Arrays.toString(array));
	        bubbleSort(array);
	        System.out.println("Sorted array: " + Arrays.toString(array));
	}
	 static void bubbleSort(int[] array) {
	        int n = array.length;
	        boolean swapped;
	        for (int i = 0; i < n - 1; i++) {
	            swapped = false;
	            for (int j = 0; j < n - i - 1; j++) {
	                if (array[j] > array[j + 1]) {
	                    // swap arr[j] and arr[j+1]
	                    int temp = array[j];
	                    array[j] = array[j + 1];
	                    array[j + 1] = temp;
	                    swapped = true;
	                }
	            }

	            // If no two elements were swapped in the inner loop, then break
	            if (!swapped)
	                break;
	        }
		

}
}
