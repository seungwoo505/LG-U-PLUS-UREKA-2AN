package test;

public class fourteen {
	public int solution(int a, int b) {
		int s = Integer.parseInt(a + "" + b);
		int i = 2 * a * b;
        return s >= i ? s : i;
    }
}
