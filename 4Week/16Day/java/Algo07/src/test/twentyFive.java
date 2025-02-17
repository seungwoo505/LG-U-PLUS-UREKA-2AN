package test;

public class twentyFive {
	public int[] solution(String my_string) {
        int[] count = new int[52];
        
        String[] str = my_string.split("");
        
        for(String s : str) { // 대문자 65, 소문자 97
        	if(s.charAt(0) - 65 <= 26) {
        		count[s.charAt(0) - 65]++;
        	}else {
        		count[s.charAt(0) - 71]++;
        	}
        }
        
        return count;
    }
}
