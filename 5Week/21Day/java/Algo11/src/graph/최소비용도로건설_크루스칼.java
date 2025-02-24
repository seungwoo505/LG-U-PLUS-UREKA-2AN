package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import graph.크루스칼.Edge;

public class 최소비용도로건설_크루스칼 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); //도시 개수
		int M = Integer.parseInt(st.nextToken()); //도로 개수
		
		Erection[] arr = new Erection[M];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int u = Integer.parseInt(st.nextToken()); // 도시 1
			int v = Integer.parseInt(st.nextToken()); // 도시 2
			int k = Integer.parseInt(st.nextToken()); // 두 도시를 연결하는 도로 건설 비용
			
			arr[i] = new Erection(u, v, k);
		}
		
		Arrays.sort(arr);
		
		makeSet(N + 1);
		
		int result = 0;
		int pickCnt = 0;
		
		for(Erection e : arr) {
			if(union(e.u, e.v)) {
				result += e.k;
				if(++pickCnt == N) {
					break;
				}
			}
		}
		
		System.out.println(result);
	}
	
	static int[] p;
	
	static void makeSet(int N) {
		p = new int[N];
		
		for(int i = 1; i < N; i++) {
			p[i] = i;
		}
	}
	
	static int find(int e) {
		if(e != p[e]) {
			p[e] = find(p[e]);
		}
		return p[e];
	}
	
	static boolean union(int u, int v) {
		int up = find(u);
		int vp = find(v);
		
		if(up == vp) {
			return false;
		}
		
		p[vp] = up;
		return true;
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
