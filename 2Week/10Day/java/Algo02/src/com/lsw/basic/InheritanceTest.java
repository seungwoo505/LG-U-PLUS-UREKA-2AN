package com.lsw.basic;

public class InheritanceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InheritanceTest t = new InheritanceTest();
		
		String s = t.toString();
		int i = t.hashCode();
		
		System.out.println(s);
		System.out.println(i);
		
		InheritanceTest t2 = new InheritanceTest();
		
		System.out.println(t==t2);
		System.out.println(t.equals(t2)); // 주소값 비교
	}
}