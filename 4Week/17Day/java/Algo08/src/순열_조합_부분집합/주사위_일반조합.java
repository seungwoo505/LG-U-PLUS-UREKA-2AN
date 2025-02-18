package 순열_조합_부분집합;

import java.util.Arrays;

public class 주사위_일반조합 {
	static int n;
	static int[] result;
	static int totalCnt = 0;
	
	public static void main(String[] args) {
		n = 2;
		result = new int[n];
		
		주사위던지기(0, 1);
		System.out.println(totalCnt);
	}

	private static void 주사위던지기(int cnt, int start) {
		// TODO Auto-generated method stub
		if(cnt == n) {
			System.out.println(Arrays.toString(result));
			totalCnt++;
			return;
		}
		
		for(int i = start; i <= 6; i++) {
			result[cnt] = i;
			주사위던지기(cnt + 1, i + 1);
		}
	}
}
