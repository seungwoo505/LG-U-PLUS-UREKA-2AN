package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BFS_최단경로2 {
	
	static class Node{
		int no;
		Node parent;
		
		Node(int no, Node parent){
			super();
			this.no = no;
			this.parent = parent;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int M = scan.nextInt();
		
		int[][] arr = new int[N + 1][N + 1];
		
		for(int i = 0; i < M; i++) {
			int from = scan.nextInt();
			int to = scan.nextInt();
			arr[from][to] = arr[to][from]  = 1;
		}
		
		int start = scan.nextInt();
		int end = scan.nextInt();
		
		StringBuilder sb = new StringBuilder();
		Queue<Node> q = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];
		boolean found = false;
		Node targetNode = null;
		
		q.offer(new Node(start, null));
		visited[start] = true;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			if(cur.no == end) {
				found = true;
				targetNode = cur;
				break;
			}
			
			for(int i = 1; i <= N; i++) {
				if(!visited[i] && arr[cur.no][i] != 0) {
					q.offer(new Node(i, cur));
					visited[i] = true;
				}
			}
		}
		
		if(found) {
			Node temp = targetNode;
			
			while(temp != null) {
				sb.insert(0, temp.no + " ");
				temp = temp.parent;
			}
			
			System.out.println(sb);
			
		}else {
			System.out.println(-1);
		}
		
	}
}