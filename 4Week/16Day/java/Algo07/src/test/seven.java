package test;

public class seven {
	public String solution(String myString, String pat) {
        String answer = (String) myString.subSequence(0, myString.lastIndexOf(pat) + pat.length());
        
        System.out.println(answer);
        return answer;
    }
}
