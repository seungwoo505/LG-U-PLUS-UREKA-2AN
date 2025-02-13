package recur;

public class Test {
	public static void main(String[] args) {
		int n = 10;
		
		printNos(n);
	}
	
	public static void printNos(int n) {
		if(n > 0) {
			printNos(n-1); // 재귀
			System.out.println(n + " ");
		}
	}
}
