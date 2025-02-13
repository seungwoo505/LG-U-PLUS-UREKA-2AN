package test;

import java.util.ArrayList;

public class seven {
	public int[] solution(int[] arr) {
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(int i : arr) {
        	for(int j = 0; j < i; j++) {
        		answer.add(i);
        	}
        }
        int[] ans = new int[answer.size()];
        
        for(int i = 0; i < ans.length; i++) {
        	ans[i] = answer.get(i);
        }
        return ans;
    }
}
