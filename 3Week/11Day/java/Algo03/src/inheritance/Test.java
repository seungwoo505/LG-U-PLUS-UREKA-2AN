package inheritance;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A b = new B();
		
		b.printI();
	}

}

class A{
	int i = 10;
	
	public void printI() {
		System.out.println(i);
	}
}

class B extends A{
	int j = 10;
	
	public void printJ() {
		System.out.println(j);
	}
}