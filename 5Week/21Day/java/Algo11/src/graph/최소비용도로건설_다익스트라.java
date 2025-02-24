package graph;

import java.io.*;
import java.util.*;

public class 최소비용도로건설_다익스트라 {
    
    static class Node implements Comparable<Node> {
        int vertex, cost;
        
        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);  // 비용 기준으로 오름차순 정렬
        }
    }

    static List<List<Node>> graph;
    static int[] dist;
    static final int INF = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken()); // 도시 개수
        int M = Integer.parseInt(st.nextToken()); // 도로 개수
        
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            
            graph.get(A).add(new Node(B, C));
            graph.get(B).add(new Node(A, C));  // 양방향 도로
        }
        
        int start = Integer.parseInt(br.readLine());  // 출발 도시
        
        dijkstra(start, N);
        
        for (int i = 1; i <= N; i++) {
            System.out.println(dist[i] == INF ? -1 : dist[i]);
        }
    }

    static void dijkstra(int start, int N) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist = new int[N + 1];
        Arrays.fill(dist, INF);
        
        dist[start] = 0;
        pq.add(new Node(start, 0));
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.vertex;
            
            if (current.cost > dist[u]) continue;  // 기존 거리보다 크면 무시
            
            for (Node next : graph.get(u)) {
                int v = next.vertex;
                int newCost = dist[u] + next.cost;
                
                if (newCost < dist[v]) {
                    dist[v] = newCost;
                    pq.add(new Node(v, newCost));
                }
            }
        }
    }
}
