package test;

public class twentyOne {
	public String[] solution(String[] names) {
        String[] answer = new String[names.length / 5 + (names.length % 5 != 0 ? 1 : 0)];
        int count = 0;
        
        for(int i = 0; i < names.length; i = i + 5) {
        	answer[count++] = names[i];
        }
        return answer;
    }
}
