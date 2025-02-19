package Tree;

import java.util.Arrays;
import java.util.Scanner;

public class 백준_1920_수찾기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int arr[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		
		Arrays.sort(arr);
		
		int m = scan.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < m; i++) {
			int target = scan.nextInt();
			int index = Arrays.binarySearch(arr, target);
			sb.append(index >= 0 ? "1\n" : "0\n");
		}
		
		System.out.print(sb);
		scan.close();
	}

}
