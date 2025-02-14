package test;

import java.util.Arrays;

public class twentyFive {
	public String[] solution(String myString) {
		String[] str = myString.split("x");
		int len = 0;
		
		for(String s : str) {
			if(!s.equals("")) {
				len++;
			}
		}
        String[] answer = new String[len];
        
        int count = 0;
        
        for(String s : str) {
        	if(!s.equals("")) {
				answer[count++] = s;
			}
        }
        Arrays.sort(answer);
        return answer;
    }
}
