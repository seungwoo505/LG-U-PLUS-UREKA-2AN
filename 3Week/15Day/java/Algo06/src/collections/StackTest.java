package collections;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		Stack<String> stack = new Stack(); // stack instance 생성
		 
		stack.push("첫 번째");
		stack.push("두 번째");
		stack.push("세 번째");
		
		System.out.println("현 stack : " + stack);
		
		String top = stack.pop();
		
		System.out.println("제거된 요소 : " + top);
		
		String peek = stack.peek();
		
		System.out.println("맨 앞 요소 : " + peek);
		System.out.println("peek 후 stack : " + stack);
		
		boolean isEmpty = stack.isEmpty();
		System.out.println("스택이 비어있나요? : " + isEmpty);
	}

}