package test;

public class three {
	public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length * k];
        int count = 0;
        for(int i = 0; i < picture.length; i++) {
        	String[] str = picture[i].split("");
        	StringBuilder sb = new StringBuilder();
        	
        	for(String s : str) {
        		for(int j = 0; j < k; j++) {
        			sb.append(s);
        		}
        	}
        	for(int j = 0; j < k; j++){
                answer[count++] = sb.toString();
            }
        }
        return answer;
    }
}
