package datastructures;

public class Bubble_Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[]= {8,6,9,5,1,3};
		int size = nums.length;
		int temp=0;
		
		System.out.println("Before Sorting");
		for (int num : nums) {
			System.out.print(num+ " ");
		}
		
		
		for(int i=0;i<size;i++) {
			for(int j=0;j<size-i-1;j++) {// J ends before the last value
				if(nums[j]>nums[j+1]) {
					temp=nums[j]; //Swapping
					nums[j]=nums[j+1];//Swapping
					nums[j+1]=temp;//Swapping
				}
			}
		}
		
		System.out.println();
		System.out.println("After Sorting");
		for (int num : nums) {
			System.out.print(num+ " ");
		}
	}

}
