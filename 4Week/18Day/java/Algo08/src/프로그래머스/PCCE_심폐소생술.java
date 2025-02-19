package 프로그래머스;

public class PCCE_심폐소생술 {
	 public int[] solution(String[] cpr) {
	        int[] answer = {0, 0, 0, 0, 0};
	        String[] basic_order = {"check", "call", "pressure", "respiration", "repeat"};
	        
	        for(int i=0; i<cpr.length; i++){
	            for(int j=0; j<basic_order.length; j++){
	                if(cpr[i].equals(basic_order[j])){
	                    answer[i] = j + 1;
	                    break;
	                }
	            }
	        }
	        return answer;
	    }
}
