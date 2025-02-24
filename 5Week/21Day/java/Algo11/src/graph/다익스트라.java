package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 다익스트라 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int V = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		int start = Integer.parseInt(s[0]);
		int end = Integer.parseInt(s[1]);
		int E = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[V][V];
		
		for(int i = 0; i < E; i++) {
			String[] ftw = br.readLine().split(" ");
			
			int f = Integer.parseInt(ftw[0]);
			int t = Integer.parseInt(ftw[1]);
			int w = Integer.parseInt(ftw[2]);
			
			arr[f][t] = arr[t][f] = w;
		}
		
		boolean[] visited = new boolean[V];
		int[] minDistence = new int[V];
		
		for(int i = 0; i < V; i++) {
			minDistence[i] = Integer.MAX_VALUE;
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		pq.offer(new Edge(start, start, 0));
		minDistence[start] = 0;
		
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			
			if(visited[e.t]) {
				continue;
			}
			
			visited[e.t] = true;
			
			if(e.t == end) {
				break;
			}
			
			for(int i = 0; i < V; i++) {
				int newMoney = e.w + arr[e.t][i];
				int nowMoney = minDistence[i];
				if(!visited[i] && arr[e.t][i] != 0 && nowMoney > newMoney) {
					minDistence[i] = newMoney;
					pq.offer(new Edge(e.t, i, minDistence[i]));
				}
			}
		}
		
		System.out.println(minDistence[end]);
	}
	
	static class Edge implements Comparable<Edge>{
		int f, t, w;

		public Edge(int f, int t, int w) {
			super();
			this.f = f;
			this.t = t;
			this.w = w;
		}

		@Override
		public String toString() {
			return "Edge [f=" + f + ", t=" + t + ", w=" + w + "]";
		}
		
		@Override
		public int compareTo(Edge e) {
			return Integer.compare(w, e.w);
		}
		
		
	}

}
