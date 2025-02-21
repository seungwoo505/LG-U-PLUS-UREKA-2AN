package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준_2178_미로탐색 {
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int M = scan.nextInt();
		
		int[][] arr = new int[N][M];
		
		scan.nextLine();
		
		for(int i = 0; i < N; i++) {
			String oneLine = scan.nextLine();
			for(int j = 0; j < M; j++) {
				int k = oneLine.charAt(j) - '0';
				arr[i][j] = k;
			}
		}
		
		Queue<int[]> q = new LinkedList<>();
		int[] start = {0, 0};
		boolean[][] visited = new boolean[N][M];
		
		q.offer(start);
		visited[start[0]][start[1]] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			if(cur[0] == N - 1 && cur[1] == M - 1) {
				System.out.println(arr[cur[0]][cur[1]]);
				break;
			}
			
			for(int i = 0; i < 4; i++) {
				int newX = cur[0] + dx[i];
				int newY = cur[1] + dy[i];
				
				if(newX >= 0 && newX < N && newY >= 0 && newY < M && arr[newX][newY] == 1 && !visited[newX][newY]) {
					visited[newX][newY] = true;
					arr[newX][newY] = arr[cur[0]][cur[1]] + 1;
					q.offer(new int[] {newX, newY});
				}
			}
		}
	}

}
