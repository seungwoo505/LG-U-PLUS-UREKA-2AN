package test;

public class twenty {
	public String solution(int q, int r, String code) {
        StringBuilder answer = new StringBuilder();
        
        String[] str = code.split("");
        
        for(int i = 0; i < str.length; i++) {
        	if(i % q == r) {
        		answer.append(str[i]);
        	}
        }
        
        return answer.toString();
    }
}
