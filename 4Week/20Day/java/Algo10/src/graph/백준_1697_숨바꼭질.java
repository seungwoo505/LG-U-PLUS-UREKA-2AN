package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 백준_1697_숨바꼭질 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
		
		int[] zone = new int[100001];
		
		zone[N] = 0;
		Deque<Integer> deque = new ArrayDeque<>();
		
		deque.offer(N);
		
		while(!deque.isEmpty()) {
			int nowPoint = deque.poll();
			
			if(nowPoint == K) {
				System.out.println(zone[nowPoint]);
				break;
			}
			
			if(nowPoint + 1 <= 100000 && ( zone[nowPoint + 1] == 0 || zone[nowPoint + 1] >= (zone[nowPoint] + 1))) {
				deque.offer(nowPoint + 1);
				zone[nowPoint + 1] = zone[nowPoint] + 1;
			}
			
			if(nowPoint - 1 >= 0 && ( zone[nowPoint - 1] == 0 || zone[nowPoint - 1] >= (zone[nowPoint] + 1))) {
				deque.offer(nowPoint - 1);
				zone[nowPoint - 1] = zone[nowPoint] + 1;
			}
			
			if(nowPoint * 2 <= 100000 && ( zone[nowPoint * 2] == 0 || zone[nowPoint * 2] >= (zone[nowPoint] + 1))) {
				deque.offer(nowPoint * 2);
				zone[nowPoint * 2] = zone[nowPoint] + 1;
			}
		}
	}
}