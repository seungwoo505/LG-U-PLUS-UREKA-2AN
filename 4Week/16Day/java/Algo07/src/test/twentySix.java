package test;

import java.util.Stack;

public class twentySix {
	public int[] solution(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < arr.length; i++) {
			if(stack.isEmpty()) {
				stack.add(arr[i]);
			}else if(stack.peek() < arr[i]) {
				stack.add(arr[i]);
			}else{
				stack.pop();
				i--;
			}
		}
		
		int[] answer = new int[stack.size()];
		Object[] o = stack.toArray();
		
		for(int i = 0; i < answer.length; i++) {
			answer[i] = (int) o[i];
		}
        return answer;
    }
}
