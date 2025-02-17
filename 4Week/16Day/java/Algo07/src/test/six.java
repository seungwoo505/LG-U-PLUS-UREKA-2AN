package test;

public class six {
	public int solution(String myString, String pat) {
		String[] str = myString.split("");
        int answer = 0;
        StringBuilder sb = new StringBuilder(pat.length());
        
        for(String s : str) {
        	if(sb.length() == pat.length()) {
        		sb.replace(0, 1, "");
        	}
            sb.append(s);
            
        	if(sb.toString().equals(pat)) {
        		answer++;
        	}
        }
        return answer;
    }
}
