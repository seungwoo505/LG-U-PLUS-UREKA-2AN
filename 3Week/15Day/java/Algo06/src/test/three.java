package test;

import java.util.ArrayList;

public class three {
	public int[] solution(int[] arr, int[] delete_list) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i : arr) {
        	int count = 0;
        	for(int j : delete_list) {
        		if(i == j) {
        			break;
        		}else {
        			count++;
        		}
        	}
        	if(count == delete_list.length) {
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