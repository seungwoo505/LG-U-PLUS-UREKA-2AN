package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BFS_최단경로 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int M = scan.nextInt();
		
		List<List<Integer>> list = new ArrayList<>();
		
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			int from = scan.nextInt();
			int to = scan.nextInt();
			list.get(from).add(to);
			list.get(to).add(from);
		}
		
		int start = scan.nextInt();
		int end = scan.nextInt();
		
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];
		int[] parent = new int[N + 1];
		boolean found = false;
		
		q.offer(start);
		visited[start] = true;
		parent[start] = -1;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			if(cur == end) {
				found = true;
				break;
			}
			
			for(int i : list.get(cur)) {
				if(!visited[i]) {
					q.offer(i);
					visited[i] = true;
					parent[i] = cur;
				}
			}
		}
		
		if(found) {
			for(int at = end; at != -1; at=parent[at]) {
				sb.append(at).append(" ");
			}
			System.out.println(sb.reverse().toString().trim());
			
		}else {
			System.out.println(-1);
		}
	}
}