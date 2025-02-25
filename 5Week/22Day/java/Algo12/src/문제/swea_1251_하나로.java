package 문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class swea_1251_하나로 {
	
	static class Edge implements Comparable<Edge> {
		int start, end;
		double cost;
		
		
		public Edge(int start, int end, double cost) {
			super();
			this.start = start;
			this.end = end;
			this.cost = cost;
		}


		@Override
		public int compareTo(Edge E) {
			return Double.compare(this.cost, E.cost);
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			sb.append("#")
			  .append(t)
			  .append(" ");
			
			int N = Integer.parseInt(br.readLine());
			
			int[] X = new int[N], Y = new int[N];
			int cnt = 0;
			for(String s : br.readLine().split(" ")) {
				X[cnt++] = Integer.parseInt(s);
			}
			
			cnt = 0;
			for(String s : br.readLine().split(" ")) {
				Y[cnt++] = Integer.parseInt(s);
			}
			
			double E = Double.parseDouble(br.readLine());
			
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			
			for(int i = 0; i < N; i++) {
				for(int j = i + 1; j < N; j++) {
					double dist = Math.pow(X[i] - X[j], 2) + Math.pow(Y[i] - Y[j], 2);
					pq.offer(new Edge(i, j, E * dist));
				}
			}
			
			int[] parent = new int[N];
			
			for(int i = 0; i < N; i++) {
				parent[i] = i;
			}
			
			double result = 0;
			int count = 0;
			
			while(!pq.isEmpty()) {
				Edge edge = pq.poll();
				if(union(edge.start, edge.end, parent)) {
					result += edge.cost;
					
					if(++count == N - 1) {
						break;
					}
				}
			}
			
			sb.append(Math.round(result))
			  .append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	static int find(int land, int[] parent) {
		if(land == parent[land]) {
			return land;
		}else {
			return parent[land] = find(parent[land], parent);
		}
	}

	static boolean union(int start, int end, int[] parent) {
		int A = find(start, parent);
		int B = find(end, parent);
		
		if(A != B) {
			parent[B] = A;
			return true;
		}
		return false;
	}
}
