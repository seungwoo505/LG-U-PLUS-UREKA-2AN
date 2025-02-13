package test;

public class thirtyNine {
	public String solution(int[] numLog) {
        StringBuilder answer = new StringBuilder(numLog.length);
        
        int ans = numLog[0];
        
        for(int i = 1; i < numLog.length; i++) { 
        	answer.append(numLog[i] - ans == 1 ? "w" : numLog[i] - ans  == -1 ? "s" : numLog[i] - ans  == 10 ? "d" : "a" );
        	ans = numLog[i] - ans;
        }
        return answer.toString();
    }
}
