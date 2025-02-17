package test;

import java.util.ArrayList;

public class ten {
	public int[] solution(String[] intStrs, int k, int s, int l) {
		ArrayList<Integer> list = new ArrayList<>();
		
		for(String str : intStrs) {
			int i = Integer.parseInt(str.substring(s, s + l));
			
			if(i > k) {
				list.add(i);
			}
		}
        int[] answer = new int[list.size()];
        
        for(int i = 0; i < answer.length; i++) {
        	answer[i] = list.get(i);
        }
        return answer;
    }
}
