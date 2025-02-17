package test;

import java.util.Stack;

public class twentyThree {
	public int[] solution(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		
		for(int i : arr) {
			if(stack.isEmpty()) {
				stack.add(i);
			}else if(stack.peek() == i) {
				stack.pop();
			}else {
				stack.add(i);
			}
		}
		if(stack.isEmpty()) {
			return new int[] { -1 };
		}
		Object[] o = stack.toArray();
		int[] answer = new int[o.length];
		
		for(int i = 0; i < answer.length; i++) {
			answer[i] = (int)o[i];
		}
        return answer;
    }
}
