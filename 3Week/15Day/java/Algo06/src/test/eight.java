package test;

public class eight {
	public int[] solution(String myString) {
        String[] str = myString.split("x");
        int[] answer = new int[str.length + (myString.split("")[myString.length() - 1].equals("x") ? 1 : 0)];
        
        for(int i = 0; i < str.length; i++) {
        	answer[i] = str[i].length();
        }
        return answer;
    }
}
