package test;

public class nine {
	public int solution(String myString, String pat) {
		String[] str = myString.split("");
        StringBuilder answer = new StringBuilder(str.length);
        
        for(int i = 0; i < str.length; i++) {
        	answer.append(str[i].equals("A") ? "B" : "A");
        }
        return answer.indexOf(pat) != -1 ? 1 : 0;
    }
}
