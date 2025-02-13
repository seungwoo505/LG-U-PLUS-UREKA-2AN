package test;

public class fortyTwo {
	public int solution(int[] num_list) {
		int sum = 0;
		int product = 1;
		
		for(int i : num_list) {
			sum += i;
			product *= i;
		}
		
		return Math.pow(sum, 2) > product ? 1 : 0;
    }
}
