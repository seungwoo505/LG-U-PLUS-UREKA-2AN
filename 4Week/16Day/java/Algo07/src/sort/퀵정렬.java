package sort;

import java.util.Arrays;

public class 퀵정렬 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {8, 4, 3, 1, 6, 7, 11, 9, 2, 10, 5};
		System.out.println("정렬 전 : " + Arrays.toString(arr));
		quikSort(arr, 0, arr.length-1);
		System.out.println("정렬 후 : " + Arrays.toString(arr));
	}

	private static void quikSort(int[] arr, int low, int high) {
		// TODO Auto-generated method stub
		if(low < high) {
			int pivotIndex = partition(arr, low, high);
			
			quikSort(arr, low, pivotIndex - 1);
			quikSort(arr, pivotIndex + 1, high);
		}
	}
	
	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int j = low-1;
		for(int i = low; i < high; i++) {
			if(arr[i] < pivot) {
				j++;
				swap(arr, j, i);
			}
		}
		swap(arr, j + 1, high);
		return j + 1;
	}
	
	private static void swap(int[] arr, int j, int i) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}

}
