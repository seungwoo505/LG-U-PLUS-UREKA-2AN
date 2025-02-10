package inheritance;

public class Rectangle extends Shape{
	int width = 5, height = 6;
	
	public void areaRec() {
		System.out.println("사각형의 넓이 : " + width * height);
	}
	
	@Override
	public void area() {
		System.out.println("사각형의 넓이 : " + width * height);
	}
}
