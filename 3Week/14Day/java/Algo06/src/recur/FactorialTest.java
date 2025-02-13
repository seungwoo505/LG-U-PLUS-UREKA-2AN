package recur;

public class FactorialTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int result = 1;
		
		for (int i = 1; i <= n; i++) {
			result *= i;
		}
		
		/*
		 *  동일환 결과 값을 가짐
		 *  재귀의 경우 for문보다 느리다.(성능이 나쁨)
		 *  
		 *  다만 명확히 몇 번을 돌아야하는지 모를 때나
		 *  복잡한 문제의 경우 재귀를 사용하는 것이 빠를 수 있다.
		 */
		System.out.println(result);
		
		System.out.println(factorial(n));
	}
	
	public static int factorial(int n) {
		if(n == 1) {
			return 1;
		}
		return n * factorial(n-1);
	}
}
