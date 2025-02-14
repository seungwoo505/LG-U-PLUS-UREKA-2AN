package collections;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		// Collections.reverseOrder()은 역순으로 하고 싶을 때(내림차순)
		Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		/**
		 * 이진 트리 구조이기 때문에
		 * 
		 * 일반적인 큐와는 다름
		 */
		pq.offer(30);
		pq.offer(10);
		pq.offer(20);
		pq.offer(50);
		pq.offer(40);
		pq.offer(5);
		pq.offer(25);
		pq.offer(15);
		pq.offer(35);
		pq.offer(1);
		
		/**
		 * 아래를 보면 알 수 있듯이 PriorityQueue의 최상단은 항상 최소값을 보장할 수 있다.
		 */
		System.out.println("현 큐 상태 : " + pq);
		
		Integer min = pq.poll();
		
		System.out.println("가장 작은 수 : " + min);
		System.out.println("현 큐 상태 : " + pq);
		
		min = pq.poll();
		
		System.out.println("가장 작은 수 : " + min);
		System.out.println("현 큐 상태 : " + pq);
	}

}
