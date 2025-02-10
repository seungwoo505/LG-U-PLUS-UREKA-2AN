package inheritance;

public class Printer {
	
	/*
	
	//확장성이 떨어짐, 새로운 것이 나올 때마다 추가해야하는 문제 발생
	public void print(Circle c) {
		c.areaCircle();
	}
	
	public void print(Rectangle r) {
		r.areaRec();
	}
	
	public void print(Triangle t) {
		t.areaTri();
	}
	
	public void print(Object o) {
		// 확장성은 확보를 했으나 성능을 떨어트림
		// (확장성을 완전히 확보한 것이 아님 차라리 위처럼 overloading 하는 것이 더 좋음)
		if( o instanceof Circle ) {
			Circle c = (Circle)o;
			c.areaCircle();
		}
		
	}
	
	*/
	
	public void print(Shape o) {
		/**
		 * 확장성 향상, 성능 향상
		 * 
		 * 위의 코드들은 확장성도 어렵고 성능도 떨어트린다.
		 * 
		 * Shape 클래스 안에 area를 만들고 해당하는 클래스에 상속하여 override를하면 Shape의 area가 아닌 실제 객체의 overriding된 매소드를 사용
		 */
		o.area();
	}
}
