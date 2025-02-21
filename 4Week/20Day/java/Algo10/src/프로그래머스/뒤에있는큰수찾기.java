package 프로그래머스;

import java.util.ArrayDeque;
import java.util.Deque;

public class 뒤에있는큰수찾기 {

	public int[] solution(int[] numbers) {
		int len = numbers.length;
        int[] answer = new int[len];
        Deque<Integer> deque = new ArrayDeque<>();
        
        deque.offer(numbers[len - 1]);
        answer[len - 1] = -1;
        
        for(int i = len - 1; i >= 0; i--) {
        	while(!deque.isEmpty() && deque.peekLast() <= numbers[i]) {
        		deque.pollLast();
        	}
        	
        	if(deque.isEmpty()) {
        		answer[i] = -1;
        	}else {
        		answer[i] = deque.peekLast();
        	}
        	
        	deque.offer(numbers[i]);
        	
        }
        
        return answer;
    }
}