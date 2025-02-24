package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 크루스칼 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int V = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		
		Edge[] arr = new Edge[E];
		
		for(int i = 0; i < E; i++) {
			String[] ftw = br.readLine().split(" ");
			
			int f = Integer.parseInt(ftw[0]);
			int t = Integer.parseInt(ftw[1]);
			int w = Integer.parseInt(ftw[2]);
			
			arr[i] = new Edge(f, t, w);
		}
		
		Arrays.sort(arr);
		
		makeSet(V);
		
		int result = 0;
		int pickCnt = 0;
		
		for(Edge e : arr) {
			if(union(e.f, e.t)) {
				result += e.w;
				if(++pickCnt == (V - 1)) {
					break;
				}
			}
		}
		
		System.out.println(result);
	}
	
	static int[] p;
	
	static void makeSet(int V) {
		p = new int[V];
		
		for(int i = 0; i < V; i++) {
			p[i] = i;
		}
	}
	
	static int find(int e) {
		if(e != p[e]) {
			p[e] = find(p[e]);
		}
		return p[e];
	}
	
	static boolean union(int f, int t) {
		int fp = find(f);
		int tp = find(t);
		
		if(fp == tp) {
			return false;
		}
		
		p[tp] = fp;
		return true;
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
