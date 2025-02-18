package test;

import java.util.ArrayList;

public class seven {
	public int[] solution(int l, int r) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = l; i <= r; i++) {
        	String str = i + "";
        	String s = str.replaceAll("0", "").replaceAll("5", "");
        	
        	if(s.equals("")){
        		list.add(i);
        	}
        }
        
        if(list.size() == 0) {
        	return new int[] { -1 };
        }
        
        list.sort((n1, n2) -> n1 - n2);
        int[] answer = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++) {
        	answer[i] = list.get(i);
        }
        return answer;
    }
}
