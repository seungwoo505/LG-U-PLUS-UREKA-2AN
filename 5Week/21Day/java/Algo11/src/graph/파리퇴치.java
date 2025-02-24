package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 파리퇴치 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
			
			int[][] flyZone = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++) {
					flyZone[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int flyCnt = 0;
			
			for(int i = 0; i <= (N - M); i++) {
				for(int j = 0; j <= (N - M); j++) {
					int cnt = 0;
					for(int k = i; k < i + M; k++) {
						for(int l = j; l < j + M; l++) {
							cnt += flyZone[k][l];
						}
					}
					flyCnt = Math.max(flyCnt, cnt);
				}
			}
			sb.append("#")
			  .append(t)
			  .append(" ")
			  .append(flyCnt)
			  .append("\n");
		}
		System.out.println(sb);
	}

}
