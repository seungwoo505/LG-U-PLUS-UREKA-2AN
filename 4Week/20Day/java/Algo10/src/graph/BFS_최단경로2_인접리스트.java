package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BFS_최단경로2_인접리스트 {
	
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
		
		List<List<Node>> list = new ArrayList();
		
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList());
		}
		
		for(int i = 0; i < M; i++) {
			int from = scan.nextInt();
			int to = scan.nextInt();
			list.get(from).add(new Node(to, null));
			list.get(to).add(new Node(from, null));
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
			
			for(Node n : list.get(cur.no)) {
				if(!visited[n.no]) {
					q.offer(new Node(n.no, cur));
					visited[n.no] = true;
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