package test;

import java.util.ArrayList;

public class twentySix {
	public String[] solution(String[] strArr) {
		ArrayList<String> list = new ArrayList<>();
        for(String s : strArr) {
        	if(s.indexOf("ad") == -1) {
        		list.add(s);
        	}
        }
        
        String[] answer = new String[list.size()];
        
        for(int i = 0; i  < answer.length; i++) {
        	answer[i] = list.get(i);
        }
        
        return answer;
    }
}
