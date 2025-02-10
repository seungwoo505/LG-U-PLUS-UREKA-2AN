package inheritance;

public class Circle extends Shape{
	int radius = 4;
	
	public void areaCircle() {
		System.out.println("원의 넓이 : " + Math.PI * radius * radius);
	}
	
	@Override
	public void area() {
		System.out.println("원의 넓이 : " + Math.PI * radius * radius);
	}
}

