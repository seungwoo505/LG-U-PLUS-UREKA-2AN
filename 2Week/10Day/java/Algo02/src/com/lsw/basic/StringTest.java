package com.lsw.basic;

public class StringTest {

	public static void main(String[] args) {
		/**
		 * string을 사용할 때 new 키워드와 함께 작성하면
		 * 같은 내용이더라도 매번 새로운 메모리를 가지게된다.
		 * 만약 같은 내용이 반복되는 상황이라면
		 * 메모리 문제가 발생될 것이다.
		 * 
		 * 그래서 new 없이 "" 만으로 작성할 수 있게 바꾼 것이다.
		 * 
		 * 그러면 같은 주소를 공유하며
		 * 만약 그 중 하나를 변경할 때
		 * 직접 변경되는 것이 아닌
		 * 새로운 메모리를 할당하여 재배정한다.
		 */
		String s1 = new String("java");
		String s2 = new String("java");
		
		String s3 = "java";
		String s4 = "java";
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1==s2);
		
		System.out.println(s3);
		System.out.println(s4);
		System.out.println(s3==s4);
		
		s3 = "Wava";
		System.out.println(s3);
		System.out.println(s4);
		System.out.println(s3==s4);
		
		// String은 불변(상수)이기 때문에 변경시킬수없어 새로운 메모리로 생성
		// 그리고 그걸 담을 그릇이 필요하기에 s5를 생성
		String s5 = s4.concat(s3);
		System.out.println(s5);
		System.out.println(s3==s5);
		System.out.println(s4==s5);
		System.out.println(s3==s4);
		
	}

}
