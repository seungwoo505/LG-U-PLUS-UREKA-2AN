package test;

public class fortyThree {
	public String solution(String[] arr) {
        StringBuilder answer = new StringBuilder(arr.length);
        for(String s : arr) {
        	answer.append(s);
        }
        return answer.toString();
    }
}
