package 프로그래머스;

import java.util.PriorityQueue;

public class 더맵게 {
	public int solution(int[] scoville, int K) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
		int count = 0;
		
		for(int i : scoville) {
			queue.add(i);
		}
		
		while(queue.size() > 1 && queue.peek() < K) {
			int first = queue.poll();
			int second = queue.poll();
			
			queue.add(first + (second * 2));
			count++;
		}
		
		return queue.peek() >= K ? count : -1;
	}

}
