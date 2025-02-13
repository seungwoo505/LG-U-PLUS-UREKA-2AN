package test;

public class fortyFive {
	public String solution(String myString) {
		String[] strings = myString.split("");
        String answer = "";
        
        for(String s : strings) {
        	if((int)s.toCharArray()[0] < (int)'l') {
        		answer += "l";
        	}else {
        		answer += s;
        	}
        }
        
        return answer;
    }
}
