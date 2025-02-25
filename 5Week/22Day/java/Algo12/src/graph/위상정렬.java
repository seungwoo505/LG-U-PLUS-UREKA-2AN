package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 위상정렬 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int M = scan.nextInt();
		
		List<List<Integer>> graph = new ArrayList<>();
		
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		int[] inDegree = new int[N + 1];
		
		for(int i = 0; i < M; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			
			graph.get(a).add(b);
			inDegree[b]++;
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i = 1; i <= N; i++) {
			if(inDegree[i] == 0) {
				pq.offer(i);
			}
		}
		
		List<Integer> result = new ArrayList<>();
		
		while(!pq.isEmpty()){
			int current = pq.poll();
			
			result.add(current);
			
			for(int n : graph.get(current)) {
				if(--inDegree[n]==0) {
					pq.offer(n);
				}
			}
		}
		for(int problem : result) {
			System.out.print(problem + " ");
		}
		scan.close();
	}
}
