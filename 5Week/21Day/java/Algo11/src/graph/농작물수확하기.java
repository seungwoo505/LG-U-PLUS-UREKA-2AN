package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 농작물수확하기 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] farm = new int[N][N];
			
			for(int n = 0; n < N; n++) {
				int i = 0;
				for(String s : br.readLine().split("")) {
					farm[n][i++] = Integer.parseInt(s);
				}
			}
			int cnt = 0;
			for(int i = 0; i <= (N - 1) / 2; i++) {
				for(int j = (N - 1) / 2 - i; j <= (N - 1) / 2 + i; j++) {
					cnt += (N - 1) / 2 == i ? farm[i][j] : (farm[i][j] + farm[(N - 1) - i][j]);
				}
			}
			sb.append("#")
			  .append(t)
			  .append(" ")
			  .append(cnt)
			  .append("\n");
		}
		
		System.out.println(sb);
	}
}