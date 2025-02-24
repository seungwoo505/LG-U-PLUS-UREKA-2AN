package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import graph.크루스칼.Edge;

public class 전력망복구_프림 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); //도시 개수
		int M = Integer.parseInt(st.nextToken()); //도로 개수
		
		int[][] arr = new int[N + 1][N + 1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int u = Integer.parseInt(st.nextToken()); // 도시 1
			int v = Integer.parseInt(st.nextToken()); // 도시 2
			int k = Integer.parseInt(st.nextToken()); // 두 도시를 연결하는 도로 건설 비용
			
			arr[u][v] = arr[v][u] = k;
		}
		
		int result = 0;
		int pickCnt = 0;
		boolean[] visited = new boolean[N + 1];
		
		PriorityQueue<Erection> pq = new PriorityQueue<>();
		
		pq.offer(new Erection(1, 1, 0));
		
		while(!pq.isEmpty()) {
			Erection e = pq.poll();
			
			if(visited[e.v]) {
				continue;
			}
			
			visited[e.v] = true;
			result += e.k;
			
			if(pickCnt == N) {
				break;
			}
			
			for(int i = 1; i <= N; i++) {
				if(!visited[i] && arr[e.v][i] != 0) {
					pq.offer(new Erection(e.v, i, arr[e.v][i]));
				}
			}
		}
		System.out.println(result);
	}
	
	static class Erection implements Comparable<Erection>{
		int u, v, k;

		public Erection(int u, int v, int k) {
			super();
			this.u = u;
			this.v = v;
			this.k = k;
		}

		@Override
		public String toString() {
			return "Edge [u=" + u + ", v=" + v + ", k=" + k + "]";
		}
		
		@Override
		public int compareTo(Erection e) {
			return Integer.compare(k, e.k);
		}
		
		
	}

}
