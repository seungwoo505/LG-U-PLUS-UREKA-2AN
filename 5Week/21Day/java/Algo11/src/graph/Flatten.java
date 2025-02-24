package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Flatten {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <= 10; t++) {
			int dump = Integer.parseInt(br.readLine());
			
			ArrayList<Integer> list = new ArrayList<>();
			
			for(String s : br.readLine().split(" ")) {
				list.add(Integer.parseInt(s));
			}
			
			for(int i = 1; i <= dump; i++) {
				list.sort(null);
				int min = list.get(0);
				int max = list.get(list.size() - 1);
				list.set(0, min + 1);
				list.set(list.size() - 1, max - 1);
			}
			
			list.sort(null);
			
			sb.append("#")
			  .append(t)
			  .append(" ")
			  .append(list.get(list.size() - 1) - list.get(0))
			  .append("\n");
		}
		
		System.out.println(sb);
		
	}

}
