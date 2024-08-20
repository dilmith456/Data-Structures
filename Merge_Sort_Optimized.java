package datastructures;

public class Merge_Sort_Optimized {

    // Function to perform Merge Sort
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) {
            return; // Array is already sorted
        }
        
        int mid = arr.length / 2;
        
        // Create left and right subarrays
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];
        
        // Copy data to left and right subarrays
        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);
        
        // Recursively sort the subarrays
        mergeSort(left);
        mergeSort(right);
        
        // Merge the sorted subarrays
        merge(arr, left, right);
    }

    // Function to merge two sorted subarrays
    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        
        // Merge the left and right arrays into arr
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        
        // Copy the remaining elements of left, if any
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        
        // Copy the remaining elements of right, if any
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    // Function to print the array
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};

        System.out.println("Original array:");
        printArray(arr);

        mergeSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}

