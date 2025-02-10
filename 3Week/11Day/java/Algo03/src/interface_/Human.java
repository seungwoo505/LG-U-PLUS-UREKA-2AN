package interface_;

public class Human extends Animal {

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("밥을 먹고 산다...");
	}
	
	public void walk() {
		System.out.println("직립보행한다.");
	}

}
