package interface_;

public class Airplance extends Vehicle implements Flyer {

	@Override
	public void transfer() {
		// TODO Auto-generated method stub
		distance = flight(0, 100);
	}
	
	public int flight(int from, int to) {
		
		return to - from;
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		flight(0, 0);
		System.out.println("엔진을 가동하며 난다...");
	}
}
