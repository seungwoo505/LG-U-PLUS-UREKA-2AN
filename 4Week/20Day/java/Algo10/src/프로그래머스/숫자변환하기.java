package 프로그래머스;

import java.util.ArrayDeque;
import java.util.Deque;

public class 숫자변환하기 {
	public int solution(int x, int y, int n) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] numberField = new int[y + 1];
        boolean[] isSelected = new boolean[y + 1];
        deque.offer(x);
        
        while(!deque.isEmpty()) {
        	int nowX = deque.pollFirst();
        	
        	if(nowX == y) {
        		return numberField[nowX];
        	}
        	
        	if(nowX + n <= y && !isSelected[nowX + n]) {
        		numberField[nowX + n] = numberField[nowX] + 1;
        		isSelected[nowX + n] = true;
        		deque.offer(nowX + n);
        	}
        	
        	if(nowX * 2 <= y && !isSelected[nowX * 2]) {
        		numberField[nowX * 2] = numberField[nowX] + 1;
        		isSelected[nowX * 2] = true;
        		deque.offer(nowX * 2);
        	}
        	
        	if(nowX * 3 <= y && !isSelected[nowX * 3]) {
        		numberField[nowX * 3] = numberField[nowX] + 1;
        		isSelected[nowX * 3] = true;
        		deque.offer(nowX * 3);
        	}
        }
        return -1;
    }
}