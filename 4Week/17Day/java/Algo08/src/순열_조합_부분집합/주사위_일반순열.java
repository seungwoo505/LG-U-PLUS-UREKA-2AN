package 순열_조합_부분집합;

import java.util.Arrays;

public class 주사위_일반순열 {
	
	static int[] result;
	static boolean[] isSelected = new boolean[7];
	static int n = 2;
	static int totalCnt; 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		n = 2;
		result = new int[n];
		
		주사위던지기(0);
		
		System.out.println(totalCnt);
	}

	private static void 주사위던지기(int cnt) {
		if(cnt == n) {
			totalCnt++;
			System.out.println(Arrays.toString(result));
			return;
		}
		for(int i = 1; i <= 6; i++) {
			if(isSelected[i]) continue;
			result[cnt] = i;
			isSelected[i] = true;
			주사위던지기(cnt + 1);
			isSelected[i] = false;
		}
	}

}
