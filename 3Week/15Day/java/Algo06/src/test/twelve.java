package test;

public class twelve {
	public int solution(int a, int b, int c) {
		return (int) ((a + b + c) * ( (a == b && a == c) || (a == b && a != c) || (a != b && a == c) || (a != b && b == c) ? (Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2)) : 1 ) * ( (a == b && a == c) ? (Math.pow(a, 3) + Math.pow(b, 3) + Math.pow(c, 3)) : 1 ));
    }
}
