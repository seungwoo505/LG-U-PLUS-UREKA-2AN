package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 인접리스트 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int m = scan.nextInt();
		
		List<List<Integer>> list = new ArrayList<>();
		
		for(int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i < m; i++) {
			int u = scan.nextInt();
			int v = scan.nextInt();
			
			list.get(u).add(v);
			list.get(v).get(u);
		}
	}
}
