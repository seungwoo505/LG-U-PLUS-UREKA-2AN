package graph;

import java.util.Scanner;

public class 인접행렬 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int m = scan.nextInt();
		
		int[][] adjM = new int[n + 1][n + 1];
		
		for(int i = 0; i < m; i++) {
			int u = scan.nextInt();
			int v = scan.nextInt();
			
			adjM[u][v] = 1;
			adjM[v][u] = 1;
		}
		
		
	}

}
