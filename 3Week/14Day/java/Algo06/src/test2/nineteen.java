package test2;

public class nineteen {
	public String solution(String my_string, int n) {
        StringBuilder answer = new StringBuilder();
        
        for(String str : my_string.split("")) {
        	for(int i = 0; i < n; i++) {
        		answer.append(str);
        	}
        }
        return answer.toString();
    }
}
