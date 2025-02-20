package graph;

import java.util.Scanner;

public class DFS_인접행렬탐색 {
	
	static StringBuilder sb = new StringBuilder();
	static int V;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		V = scan.nextInt();
		int E = scan.nextInt();
		int start = scan.nextInt();
		
		int[][] arr = new int[V + 1][V + 1];
		
		for(int i = 0; i < E; i++) {
			int u = scan.nextInt();
			int v = scan.nextInt();
			arr[u][v] = arr[v][u] = 1;
		}
		
		dfs(arr, new boolean[V + 1], start);
		
		System.out.print(sb);
	}
	
	static void dfs(int[][] adjM, boolean[] isSelected, int cur) {
		isSelected[cur] = true;
		sb.append(cur).append(" ");
		
		for(int i = 1; i <= V; i++) {
			if(!isSelected[i] && adjM[cur][i] != 0) {
				dfs(adjM, isSelected, i);
			}
		}
		
	}

}
