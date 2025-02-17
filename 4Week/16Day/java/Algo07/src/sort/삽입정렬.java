package sort;

import java.util.Arrays;

public class 삽입정렬 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {23, 1, 10, 5, 2};
		
		for(int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i - 1;
			
			while(j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
		System.out.println(Arrays.toString(arr));
	}
	

}
