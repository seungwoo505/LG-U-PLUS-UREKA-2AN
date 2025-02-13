package test;

public class thirtyTwo {
	public String solution(String my_string, int n) {
		String[] strings = my_string.split("");
		
        StringBuilder answer = new StringBuilder(n);
        
        for(int i = 0; i < n; i++) {
        	answer.append(strings[i]);
        }
        return answer.toString();
    }
}
