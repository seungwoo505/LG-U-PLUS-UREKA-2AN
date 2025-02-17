package test;

import java.util.Arrays;

public class nineteen {
	public int solution(int[] arr) {
		int[] oldArr = Arrays.copyOf(arr, arr.length);
		int[] newArr = Arrays.copyOf(arr, arr.length);
		
		for(int i = 0; i < newArr.length; i++) {
			if(newArr[i] > 50 && newArr[i] % 2 == 0) {
				newArr[i] /= 2;
			}else if(newArr[i] < 50 && newArr[i] % 2 != 0) {
				newArr[i] = (newArr[i] * 2) + 1;
			}
		}
		
		int count = 1;
        
		while(!Arrays.equals(oldArr, newArr)) {
			oldArr = Arrays.copyOf(newArr, newArr.length);
			
			for(int i = 0; i < newArr.length; i++) {
				if(newArr[i] > 50 && newArr[i] % 2 == 0) {
					newArr[i] /= 2;
				}else if(newArr[i] < 50 && newArr[i] % 2 != 0) {
					newArr[i] = (newArr[i] * 2) + 1;
				}
			}
			count++;
		}
		return count - 1;
     }
}
