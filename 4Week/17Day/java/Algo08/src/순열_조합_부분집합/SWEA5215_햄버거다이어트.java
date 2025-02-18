package 순열_조합_부분집합;

import java.util.Scanner;

public class SWEA5215_햄버거다이어트 {
	
	static int N;
	static int L;
	
	static int[] tastes;
	static int[] cals;
	static boolean[] isSelected;
	
	static int result;
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			N = scan.nextInt(); // 재료의 수
			L = scan.nextInt(); // 기준 총 칼로리
			
			tastes = new int[N];
			cals = new int[N];
			isSelected = new boolean[N];
			
			for(int i = 0; i < N; i++) {
				tastes[i] = scan.nextInt();
				cals[i] = scan.nextInt();
			}
			
			result = 0;
			subset(0);
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		
		System.out.println(sb);
	}

	private static void subset(int cnt) {
		if(cnt == N) {
			int tastesSum = 0, calsSum = 0;
			
			for(int i = 0; i < N; i++) {
				if(isSelected[i]) {
					tastesSum += tastes[i];
					calsSum += cals[i];
					
					if(calsSum > L) {
						return;
					}
				}
			}
			result = Math.max(tastesSum, result);
			return;
			
		}
		isSelected[cnt] = true;
		subset(cnt + 1);
		
		isSelected[cnt] = false;
		subset(cnt + 1);
	}

}
