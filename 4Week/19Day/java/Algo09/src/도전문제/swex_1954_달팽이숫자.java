package 도전문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swex_1954_달팽이숫자{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i <= T; i++) {
			sb.append("#")
			  .append(i)
			  .append("\n");
			
			int N = Integer.parseInt(br.readLine());
			
			int[][] snail = new int[N][N];
			
			int rowStart = 0, rowEnd = N - 1;
			int colStart = 0, colEnd = N - 1;
			int count = 1;
			
			while(rowStart <= rowEnd && colStart <= rowEnd) {
				for(int j = colStart; j <= colEnd; j++) {
					snail[rowStart][j] = count++;
				}
				rowStart++;
				
				for(int j = rowStart; j <= rowEnd; j++) {
					snail[j][colEnd] = count++;
				}
				colEnd--;
				
				for(int j = colEnd; j >= colStart; j--) {
					snail[rowEnd][j] = count++;
				}
				rowEnd--;
				
				for(int j = rowEnd; j >= rowStart; j--) {
					snail[j][colStart] = count++;
				}
				colStart++;
			}
			
			for(int j = 0; j < snail.length; j++) {
				for(int k = 0; k < snail[j].length; k++) {
					sb.append(snail[j][k])
					  .append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
