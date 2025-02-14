package test;

public class fifteen {
	public String solution(String my_string, int k) {
        StringBuilder answer = new StringBuilder(my_string.length() * k);
        
        for(int i = 0; i < k; i++) {
        	answer.append(my_string);
        }
        return answer.toString();
    }
}
