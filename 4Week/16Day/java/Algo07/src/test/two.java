package test;

public class two {
	public int solution(int a, int d, boolean[] included) {
		int len = included.length;
		int count = a;
		int answer = included[0] ? count : 0;
		
		
		for(int i = 1; i < len; i++) {
			count += d;
			answer += included[i] ? count : 0;
		}
		
		return answer;
    }
}
