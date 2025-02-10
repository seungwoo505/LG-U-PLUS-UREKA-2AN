
package inheritance;

public class PrinterMain {

	public static void main(String[] args) {
		Printer out = new Printer();
		
		Circle c = new Circle();
		Rectangle r = new Rectangle();
		Triangle t = new Triangle();
		
		out.print(c);
		out.print(r);
		out.print(t);
		
		//out.print("hello");//정합성 상승
	}
}