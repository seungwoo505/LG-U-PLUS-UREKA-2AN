package sort;

import java.util.Arrays;

public class 선택정렬 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {64, 25, 10, 22, 11};
		
		int n = nums.length;
		
		int[] sortedNums = Arrays.copyOf(nums, n);
		
		for(int i = 0; i < n - 1; i++) {
			int minIdx = i;
			for(int j = i + 1; j < n; j++) {
				if(sortedNums[minIdx] > sortedNums[j]) {
					minIdx = j;
				}
			}
			
			if(minIdx != i) {
				int temp = sortedNums[i];
				sortedNums[i] = sortedNums[minIdx];
				sortedNums[minIdx] = temp;
			}
		}
		
		//정렬 완료
		
		int thirdSmallest = sortedNums[2];
		
		int indexOfThirdSmallest = -1;
		
		for(int i = 0; i < n; i++) {
			if(nums[i] == thirdSmallest) {
				indexOfThirdSmallest = i;
				break;
			}
		}
		
		System.out.println("세 번째로 작은 수 : " + thirdSmallest);
		System.out.println("세 번째로 작은 수의 원본 배열 인덱스 : " + indexOfThirdSmallest);
		
	}

}
