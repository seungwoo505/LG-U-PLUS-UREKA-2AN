package Array1;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 2, 3, 4, 6};
		int target = 6;
		int left = 0, right = nums.length - 1;
		
		while(left < right) {
			int sum = nums[left] + nums[right];
			
			if(target == sum) {
				System.out.println(left + "와 " + right + "를 더하여 " + target + "이 나왔습니다.");
				break;
			}else if(sum < target) {
				left++;
			}else {
				right--;
			}
		}
	}
}