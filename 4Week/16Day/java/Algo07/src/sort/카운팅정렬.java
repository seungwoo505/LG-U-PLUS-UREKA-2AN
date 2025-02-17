package sort;

import java.util.Arrays;

public class 카운팅정렬 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arrs = {7, 2, 3, 5, 7, 1, 4, 6, 7, 5, 0, 1};
		int max = 7;
		int[] count = new int[max + 1];
		int[] result = new int[arrs.length];
		
		//카운팅 배열
		for(int num : arrs) {
			count[num]++;
		}
		
		//누적합 배열
		for(int i = 1; i <= max; i++) {
			count[i] += count[i - 1];
		}
		
		for(int i = arrs.length - 1; i >= 0; i--) {
			result[--count[arrs[i]]] = arrs[i];
		}
		
		System.out.println(Arrays.toString(result));
	}

}
