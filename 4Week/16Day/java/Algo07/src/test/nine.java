package test;

public class nine {
	public String solution(String my_string, int s, int e) {
        StringBuilder answer = new StringBuilder(my_string.length());

        int count = 0;
        for(int i = 0; i < my_string.length(); i++) {
            if(i >= s && i <= e) {
                answer.append(my_string.charAt(e-count++));
            } else {
                answer.append(my_string.charAt(i));
            }
        }

        return answer.toString();
    }
}
