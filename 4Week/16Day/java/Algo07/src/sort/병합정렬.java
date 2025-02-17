package sort;

import java.util.Arrays;

public class 병합정렬 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {38, 27, 43, 3, 9, 82, 10};
		
		System.out.println("정렬 전 : " + Arrays.toString(arr));
		divide(arr);
		System.out.println("정렬 후 : " + Arrays.toString(arr));
	}

	private static void divide(int[] arr) {
		// TODO Auto-generated method stub
		if(arr.length < 2) {
			return;
		}
		
		int mid = arr.length / 2;
		
		int[] left = Arrays.copyOfRange(arr, 0, mid);
		int[] right = Arrays.copyOfRange(arr, mid, arr.length);
		
		divide(left);
		divide(right);
		
		mergeSort(arr, left, right);
	}

	private static void mergeSort(int[] arr, int[] left, int[] right) {
		// TODO Auto-generated method stub
		int i = 0, j = 0, k =0;
		
		while(i < left.length && j < right.length) {
			arr[k++] = left[i] <= right[j] ? left[i++] : right[j++]; 
		}
		
		while(i < left.length) {
			arr[k++] = left[i++];
		}
		while(j < right.length) {
			arr[k++] = right[j++];
		}
	}
}