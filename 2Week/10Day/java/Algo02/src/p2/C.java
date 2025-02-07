package p2;

import p1.A;

public class C {

	public static void main(String[] args) {
		
		// 다른 패키지에 있기 때문에 import를 해야한다.
		A obj = new A();
		
		System.out.println(obj.i);
	}

}
