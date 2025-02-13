package test;

public class fortyNine {
	public int[] solution(int[] arr, int k) {
        int[] answer = new int[arr.length];
        boolean sum = k % 2 == 0;
        
        for(int i = 0; i < answer.length; i++) {
        	if(sum) answer[i] = arr[i] + k;
        	else answer[i] = arr[i] * k;
        }
        return answer;
    }
}
