package p1;

public class A {
	public int i = 10; // 어디서든 사용 가능
	
	private int i2 = 10; // A 내부에서만 사용 가능
	
	int i3 = 10; // 같은 패키지 내부에서만 사용 가능
	
	protected int i4 = 10; // 같은 패키지 내부또는 자식 클래스에서 사용 가능
}
