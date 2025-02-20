package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_인접행렬탐색 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		int V = scan.nextInt();
		int E = scan.nextInt();
		int start = scan.nextInt();
		
		int[][] arr = new int[V + 1][V + 1];
		
		boolean[] isSelected = new boolean[V + 1];
		
		for(int i = 0; i < E; i++) {
			int u = scan.nextInt();
			int v = scan.nextInt();
			arr[u][v] = arr[v][u] = 1;
		}
		
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(start);
		
		isSelected[start] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			sb.append(cur).append(" ");
			
			for(int i = 1; i <= V; i++) {
				if(!isSelected[i] && arr[cur][i] != 0) {
					q.offer(i);
					isSelected[i] = true;
				}
			}
		}
		
		System.out.println(sb);
		scan.close();
	}

}
