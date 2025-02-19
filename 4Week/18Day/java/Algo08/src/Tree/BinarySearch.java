package Tree;

import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] sortedArray = {1, 3, 5, 7, 9, 11, 13, 15};
		
		int target = 7;
		
		/**
		 * 똑같은 기능을 가짐
		 * 
		 * 자바에서 API로 제공하고 있으니 
		 */
		int result = binarySearch(sortedArray, target);
		int result2 = Arrays.binarySearch(sortedArray, target);
		
		System.out.println(result);
		System.out.println(result2);
	
	}
	
	static int binarySearch(int[] arr, int target) {
		int low = 0;
		int high = arr.length - 1;
		
		while(low <= high) {
			int mid = (low + high) / 2;
			
			if(arr[mid] == target) {
				return mid;
			}else if(arr[mid] < target) {
				low = mid + 1;
			}else {
				high = mid - 1;
			}
		}
		
		return -1;
	}
}