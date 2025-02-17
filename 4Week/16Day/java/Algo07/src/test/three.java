package test;

public class three {
	public String solution(String str1, String str2) {
		String[] s1 = str1.split(""), s2 = str2.split("");
		
        StringBuilder answer = new StringBuilder(s1.length * 2);
        
        for(int i = 0; i < s1.length; i++) {
        	answer.append(s1[i] + s2[i]);
        }
        return answer.toString();
    }
}