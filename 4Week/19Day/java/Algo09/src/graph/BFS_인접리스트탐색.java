package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BFS_인접리스트탐색 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int V = scan.nextInt();
		int E = scan.nextInt();
		int start = scan.nextInt();
		
		List<List<Integer>> list = new ArrayList<>();
		
		boolean[] isSelected = new boolean[V + 1];
		
		for(int i = 0; i <= V; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i < E; i++) {
			int u = scan.nextInt();
			int v = scan.nextInt();
			list.get(u).add(v);
			list.get(v).add(u);
		}
		
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(start);
		
		isSelected[start] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			sb.append(cur).append(" ");
			
			for(int i : list.get(cur)) {
				if(!isSelected[i]) {
					q.offer(i);
					isSelected[i] = true;
				}
			}
		}
		
		System.out.println(sb);
		scan.close();
	}

}
