package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 전력망복구_크루스칼 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken()); // 발전소 개수
        int M = Integer.parseInt(st.nextToken()); // 전력망 개수
        
        Erection[] arr = new Erection[M];
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            int u = Integer.parseInt(st.nextToken()); // 발전소 1
            int v = Integer.parseInt(st.nextToken()); // 발전소 2
            int k = Integer.parseInt(st.nextToken()); // 두 발전소를 연결하는 전력망 비용
            
            arr[i] = new Erection(u, v, k);
        }
        
        Arrays.sort(arr);  // 비용 순으로 정렬
        
        makeSet(N + 1);  // Union-Find 초기화
        
        int result = 0;
        int pickCnt = 0;
        
        for(Erection e : arr) {
            if(union(e.f, e.t)) {
                result += e.k;  // 비용 합산
                pickCnt++;
                if(pickCnt == N - 1) {  // N-1개의 도로를 선택하면 종료
                    break;
                }
            }
        }
        
        System.out.println(result);  // 최소 비용 출력
    }
    
    static int[] p;
    
    static void makeSet(int N) {
        p = new int[N];
        
        for(int i = 1; i < N; i++) {
            p[i] = i;
        }
    }
    
    static int find(int e) {
        if(e != p[e]) {
            p[e] = find(p[e]);  // 경로 압축
        }
        return p[e];
    }
    
    static boolean union(int u, int v) {
        int up = find(u);
        int vp = find(v);
        
        if(up == vp) {
            return false;  // 이미 연결된 경우
        }
        
        p[vp] = up;  // 연결
        return true;
    }
    
    static class Erection implements Comparable<Erection> {
        int f, t, k;

        public Erection(int f, int t, int k) {
            super();
            this.f = f;
            this.t = t;
            this.k = k;
        }

        @Override
        public int compareTo(Erection e) {
            return Integer.compare(this.k, e.k);  // 비용 순으로 비교
        }
    }
}
