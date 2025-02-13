package test;

public class nineteen {
	public int solution(int[] numbers, int n) {
        int answer = 0;
        for(int num : numbers) {
        	if(answer > n) {
        		return answer;
        	}
        	answer += num;
        }
        return answer;
    }
}
