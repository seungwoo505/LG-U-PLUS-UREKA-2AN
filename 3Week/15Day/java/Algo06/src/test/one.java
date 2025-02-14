package test;

public class one {
	public int solution(String number) {
        int answer = 0;
        String[] str = number.split("");
        
        for(String s : str) {
        	answer += Integer.parseInt(s);
        }
        return answer % 9;
    }
}
