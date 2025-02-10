package interface_;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bird b = new Bird();
		Superman s = new Superman();
		Airplance a = new Airplance();
		
		Show.airShow(b);
		Show.airShow(s);
		Show.airShow(a);
		//Show.airShow("hello"); // Flyer 가 아니기 때문에 불가능
		
		Flyer[] flyer = new Flyer[3];
		
		flyer[0] = b;
		flyer[1] = s;
		flyer[2] = a;
		//flyer[3] = "hello"; // Flyer 가 아니기 때문에 불가능
		Show.airShow(flyer);
	}

}

class Show {
	public static void airShow(Flyer f) {
		f.fly();
	}
	
	public static void airShow(Flyer[] f) {
		for (Flyer flyer : f) {
			flyer.fly();
		}
	}
}