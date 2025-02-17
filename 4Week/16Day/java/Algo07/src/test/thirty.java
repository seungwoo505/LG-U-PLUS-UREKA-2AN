package test;

import java.util.ArrayList;

public class thirty {
	public int[] solution(int[] arr, int k) {
        int[] answer = new int[k];
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < answer.length; i++) {
        	answer[i] = -1;
        }
        
        int count = 0;
        
        for(int i : arr) {
        	if(count >= k){
                return answer;
            }
        	if(!list.contains(i)) {
        		list.add(i);
        		answer[count++] = i; 
        	}
        }
        return answer;
    }
}
