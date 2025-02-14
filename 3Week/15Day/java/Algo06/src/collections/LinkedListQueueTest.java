package collections;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedListQueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<String> q = new LinkedList<>(); // list와 queue 2가지의 특성을 지님
		
		q.offer("첫 번째");
		q.offer("두 번째");
		q.offer("세 번째");
		
		System.out.println("현 큐 상태 : " + q);
		
		String data = q.poll();
		
		System.out.println("제거된 요소 : " + data);
		System.out.println("제거 후 큐 상태 : " + q);
		
		data = q.peek();
		
		System.out.println("맨 앞 요소 : " + data);
		System.out.println("peek 후 큐 상태 : " + q);
		
		boolean isEmpty = q.isEmpty();
		System.out.println("큐가 비어있나요? : " + isEmpty);
	}

}
