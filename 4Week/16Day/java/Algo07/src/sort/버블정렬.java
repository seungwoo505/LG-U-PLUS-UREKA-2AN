package sort;

import java.util.Arrays;

public class 버블정렬 {
	public static void main(String[] args) {
		int[] arr = {55, 7, 78, 12, 42};
		
		int n = arr.length;
		
		for(int i = n - 1; i > 0; i--) {
			for(int j = 0; j < i; j++) {
				if(arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}
}
