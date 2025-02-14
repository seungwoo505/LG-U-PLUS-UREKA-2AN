package collections;

import java.util.Scanner;

public class 백준_2740_행렬곱셉 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int m = scan.nextInt();
		
		int[][] maxtrixA = new int[n][m];
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++) {
				maxtrixA[i][j] = scan.nextInt();
			}
		}
		
		scan.nextInt();
		
		int k = scan.nextInt();
		
		int[][] maxtrixB = new int[m][k];
		
		for(int i = 0; i < m; i++){
			for(int j = 0; j < k; j++) {
				maxtrixB[i][j] = scan.nextInt();
			}
		}
		
		int[][] maxtrix = new int[n][k];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < k; j++) {
				for(int l = 0; l < m; l++) {
					maxtrix[i][j] += maxtrixA[i][l] * maxtrixB[l][j];
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < k; j++) {
				System.out.print(maxtrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}