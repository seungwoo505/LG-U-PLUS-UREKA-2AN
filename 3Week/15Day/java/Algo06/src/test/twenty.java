package test;

public class twenty {
	public int solution(int n) {
		int answer = 0;
		boolean even = n % 2 == 0;
		for(int i = n; i >= 0; i -= 2) {
			answer += even ? Math.pow(i, 2) : i;
		}
		return answer;
    }
}
