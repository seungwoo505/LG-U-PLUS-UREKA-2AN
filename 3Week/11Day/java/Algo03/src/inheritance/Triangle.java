package inheritance;

public class Triangle extends Shape{
	int width = 5, height = 6;
	
	public void areaTri() {
		System.out.println("사각형의 넓이 : " + width * height/2);
	}
	
	@Override
	public void area() {
		System.out.println("사각형의 넓이 : " + width * height/2);
	}
}
