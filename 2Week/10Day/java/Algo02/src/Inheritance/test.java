package Inheritance;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		B b = new B();
		b.printI(); //A로부터 상속 받은 것
	}

}

class A {
	int i = 10;
	
	public void printI() {
		System.out.println(i);
	}
}

class B extends A{ // A를 상속 받음
int j = 100;
	
	public void printJ() {
		System.out.println(j);
	}
}