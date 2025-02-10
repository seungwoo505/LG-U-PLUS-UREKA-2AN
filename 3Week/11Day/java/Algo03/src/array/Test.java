package array;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] cars;
		cars = new int[3];
		System.out.println(cars);
		cars[0] = 1;
		cars[1] = 2;
		cars[2] = 3;
		
		int[] cars2 = {1, 2, 3}; // 동일한 결과값을 낸다.
		
		int[] cars3 = new int[4];
		System.arraycopy(cars, 0, cars3, 0, cars.length);
		
		for(int i = 0; i < cars.length; i++) {
			System.out.println(cars[i]);
		}
		
		for(int i : cars2) { // for-Each 문
			System.out.println(i);
		}
		
		for(int i : cars3) { // for-Each 문
			System.out.println(i);
		}
	}

}