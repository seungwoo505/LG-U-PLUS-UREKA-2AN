package test;

public class thirtySix {
	public String solution(String[] my_strings, int[][] parts) {
        StringBuilder answer = new StringBuilder();
        
        for(int i = 0 ; i < parts.length; i++) {
        	String[] strings = my_strings[i].split("");
        	for(int j = parts[i][0]; j <= parts[i][1]; j++) {
        		answer.append(strings[j]);
        	}
        }
        
        return answer.toString();
    }
}
