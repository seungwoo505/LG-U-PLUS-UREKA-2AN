package test;

public class twelve {
	public String solution(String myString) {
		String[] str = myString.split("");
        StringBuilder answer = new StringBuilder(str.length);
        
        for(String s : str) {
        	if(s.equals("a") || s.equals("A")) {
        		answer.append("A");
        	}else {
        		answer.append(s.toLowerCase());
        	}
        }
        return answer.toString();
    }
}
