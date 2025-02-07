package com.lsw.basic;

public class StringTest2 {
	public static void main(String[] args) {
		String s = "java";
		
		//이렇게 하면 시간복잡도, 공간복잡도가 n만큼 증가
		for (int i = 0; i < 5; i++) {
			s += i;
			System.out.println(s);
		}
		
		//String에서 발생했던 문제를 해결한 것이 StringBuffer
		//StringBuffer s2 = new StringBuffer(100); // 만약 크기를 알고 있다면 이렇게 지정하여 사용하면 시간이 더 절약된다.
		StringBuilder s2 = new StringBuilder(100); // StringBuffer는 멀티 쓰레드를 대상으로 되어있는데 동시 접속을 막기위해 lock 시스템이 적용되어있음
												   // 그러나 javaSE는 싱글 쓰레드가 기본이라 시간 손실이 크다 / StringBuilder는 lock 시스템을 제거한 버전
		s2.append("java");
		
		for (int i = 0; i < 5; i++) {
			s2.append(i);
			System.out.println(s2);
		}
		
	}

}
