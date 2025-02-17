package test;

public class twentyEight {
	public String solution(String my_string, int[][] queries) {
        StringBuilder answer = new StringBuilder(my_string);
        for(int[] q : queries) {
			String s = answer.substring(q[0], q[1] + 1);
			String[] str = new String[] {answer.substring(0, q[0]), answer.substring(q[1] + 1, answer.length())};
			answer = new StringBuilder(str[0]);
			String[] ss = s.split("");
			
        	for(int i = ss.length - 1; i >= 0; i--) {
        		answer.append(ss[i]);
        	}
        	
        	answer.append(str[1]);
        }
        return answer.toString();
    }
}
