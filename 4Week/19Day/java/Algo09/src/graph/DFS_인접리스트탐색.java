package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DFS_인접리스트탐색 {
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), V = Integer.parseInt(st.nextToken());
		
		List<List<Integer>> list = new ArrayList<>();
		
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int start = Integer.parseInt(st.nextToken()), end = Integer.parseInt(st.nextToken());
			
			list.get(start).add(end);
			list.get(end).add(start);
		}
		
		dfs(list, new boolean[N + 1], V);
		
		System.out.println(sb);
		
		br.close();
		
	}
	
	static void dfs(List<List<Integer>> adjM, boolean[] isSelected, int cur) {
		isSelected[cur] = true;
		sb.append(cur).append(" ");
		
		for(int i : adjM.get(cur)) {
			if(!isSelected[i]) {
				dfs(adjM, isSelected, i);
			}
		}
	}
}
