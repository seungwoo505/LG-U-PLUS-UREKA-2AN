import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 평범한배낭_12865 {
	
	static class Edge implements Comparable<Edge>{
		int w, v;

		public Edge(int w, int v) {
			super();
			this.w = w;
			this.v = v;
		}

		@Override
		public int compareTo(Edge e) {
			// TODO Auto-generated method stub
			return Integer.compare(w, e.w);
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
		int[][] WV = new int[N][2];
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			WV[n][0] = Integer.parseInt(st.nextToken());
			WV[n][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(WV, (n1, n2) ->{
			if(n1[1] == n2[1]) {
				return n1[0] - n2[0];
			}
			return n2[1] - n1[1];
		});
		
		int maxBack = 0;
		int max = 0;
		for(int i = 0; i < N; i++) {
			max = 0;
			int w = 0;
			PriorityQueue<Edge> pq = new PriorityQueue<>(Collections.reverseOrder());
			for(int j = i; j < N; j++) {
				if(w == K) {
					maxBack = Math.max(max, maxBack);
				}
				
				max += WV[j][1];
				w += WV[j][0];
				pq.offer(new Edge(WV[j][0], WV[j][1]));
				
				while(w > K) {
					Edge e = pq.poll();
					max -= e.v;
					w -= e.w;
				}
			}
			maxBack = Math.max(max, maxBack);
		}
		
		System.out.println(maxBack);
	}
}