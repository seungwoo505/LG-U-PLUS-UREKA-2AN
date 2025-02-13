package test;

public class thirtyFive {
	public String solution(String my_string, int n) {
		String[] strings = my_string.split("");
        StringBuilder answer = new StringBuilder();
        
        for(int i = strings.length - 1; i >= strings.length - n; i--) {
        	answer.append(strings[i]);
        }
        return answer.reverse().toString();
    }
}
