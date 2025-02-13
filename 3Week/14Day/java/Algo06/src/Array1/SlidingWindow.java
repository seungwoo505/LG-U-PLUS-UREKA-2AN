package Array1;

public class SlidingWindow {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5};
		int k = 3; // 연속된 요소의 개수
		int result = maxSum(nums, k);
		
		System.out.println(result);
	}
	
	public static int maxSum(int[] nums, int k) {
		int n = nums.length;
		
		if(n < k) {
			throw new IllegalArgumentException("배열의 길이가 k보다 커야합니다.");
		}
		
		int maxSum = 0;
		
		for(int i = 0; i < k; i++) {
			maxSum += nums[i];
		}
		
		int windowSum = maxSum;
		
		for(int i = k; i < n; i++) {
			windowSum += nums[i] - nums[i - k];
			maxSum = Math.max(maxSum, windowSum);
		}
		return maxSum;
	}
}