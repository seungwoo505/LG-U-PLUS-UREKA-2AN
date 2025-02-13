package test;

import java.util.Arrays;

public class twentyFive {
	public int[] solution(int[] num_list, int n) {
        int[] answer = Arrays.copyOfRange(num_list, 0, n);
        int[] num = Arrays.copyOfRange(num_list, n, num_list.length);
        int[] ans = new int[num_list.length]; 
        int count = 0;
        for(int i = 0; i < num.length; i++) {
        	ans[count++] = num[i];
        }
        for(int i = 0; i < answer.length; i++) {
        	ans[count++] = answer[i];
        }
        return ans;
    }
}
