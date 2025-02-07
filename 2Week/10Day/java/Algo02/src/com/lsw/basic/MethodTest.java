package com.lsw.basic;

public class MethodTest {
	
	static int count = 0;
	
	void a1(){
		System.out.println("a1");
	}
	
	static void a2(){
		System.out.println("a2");
	}

	public static void main(String[] args) throws Exception {
		// static을 사용하지않았을 때 
		MethodTest m = new MethodTest();
		m.a1();
		
		// static을 사용할 때 ( static은 객체 생성 없이 사용할 수 있다. 다만, 자바가 실행될 때 같이 생성이 되기 때문에 메모리가 종속됨(삭제되지도 추가되지않는다.) )
		a2();
		
		m.print(10);
		m.print(10, 10.0);
		
		m.test(++count);
		System.out.println("스택의 최대치에 도달했습니다. 최대치 : " + count);
	}
	
	// 같은 기능을 하면 이름을 비슷하거나 같게 짓는게 좋다. ( 개발 편의성 상승 )
	// 다만 파라미터만 다르게 명시하면된다. 이것을 Method Overloading이라고 한다.
	void print(int i) {
		System.out.println("a 호출됨");
	}
	
	void print(int i, double d) {
		System.out.println("b 호출됨");
	}
	
	// 재귀함수 자기자신을 또 불러옴
	// 이 매소드는 스텍의 한계를 시험해보는 것이다.
	void test(int i){
		try {
			test(++count);
		}catch(StackOverflowError e) {
			
		}
	}
}
