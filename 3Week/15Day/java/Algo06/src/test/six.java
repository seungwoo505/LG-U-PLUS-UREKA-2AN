package test;

public class six {
	public String solution(String[] str_list, String ex) {
        StringBuilder answer = new StringBuilder();
        
        for(String s : str_list) {
        	if(s.indexOf(ex) != -1) {
        		continue;
        	}
        	
        	answer.append(s);
        }
        
        return answer.toString();
    }
}
