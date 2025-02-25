package 문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_2252_줄세우기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 학생 수
        int M = Integer.parseInt(st.nextToken()); // 비교 횟수

        List<Integer>[] graph = new ArrayList[N + 1]; // 인접 리스트
        int[] indegree = new int[N + 1]; // 진입 차수 배열

        // 그래프 초기화
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 관계 입력 받기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph[A].add(B); // A → B (A가 B 앞에 있어야 함)
            indegree[B]++;    // B의 진입 차수 증가
        }

        // 위상 정렬 (BFS)
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        // 진입 차수가 0인 노드를 큐에 삽입
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // 큐에서 하나씩 꺼내며 정렬 수행
        while (!queue.isEmpty()) {
            int now = queue.poll();
            sb.append(now).append(" ");

            // 현재 노드와 연결된 노드들의 진입 차수 감소
            for (int next : graph[now]) {
                // 진입 차수가 0이 되면 큐에 삽입
                if (--indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        // 결과 출력
        System.out.println(sb.toString().trim());
	}
}