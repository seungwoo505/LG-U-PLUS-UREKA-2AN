package com.lsw.basic;

public class MyprofileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyProfile m = new MyProfile();
		
		/**
		 * -100은 코드 상에서는 문제는 없다.
		 * 
		 * 다만, 나이라는 측면에선 음수가 존재할 수 없기 때문에 문제가 있다고 판단된다.
		 * 
		 * 그렇기 때문에 private으로 설정하고 get, set으로 유효성을 검사해야한다.
		 */
		//m.age = -100;
		//System.out.println(m.age);
		
		m.setAge(-100);
		System.out.println(m.getAge());
	}

}
