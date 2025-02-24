package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 프림 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int V = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[V][V];
		
		for(int i = 0; i < E; i++) {
			String[] ftw = br.readLine().split(" ");
			
			int f = Integer.parseInt(ftw[0]);
			int t = Integer.parseInt(ftw[1]);
			int w = Integer.parseInt(ftw[2]);
			
			arr[f][t] = arr[t][f] = w;
		}
		
		int result = 0;
		int pickCnt = 0;
		boolean[] visited = new boolean[V];
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		pq.offer(new Edge(0, 0, 0));
		
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			
			if(visited[e.t]) {
				continue;
			}
			
			visited[e.t] = true;
			result += e.w;
			
			if(++pickCnt == V) {
				break;
			}
			
			for(int i = 0; i < V; i++) {
				if(!visited[i] && arr[e.t][i] != 0) {
					pq.offer(new Edge(e.t, i, arr[e.t][i]));
				}
			}
		}
		
		System.out.println(result);
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
