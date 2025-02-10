package interface_;

public class Superman extends Human implements Flyer {
	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("빵을 먹고 산다.");
		System.out.println("가끔 ");
		super.eat();
	}
	
	public void fly() {
		System.out.println("망토를 펄럭이며 난다...");
	}
}
