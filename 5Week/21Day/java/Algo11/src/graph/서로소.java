package graph;

public class 서로소 {
	
	static int[] p;
	
	static void makeSet(int V) {
		p = new int[V];
		
		for(int i = 0; i < V; i++) {
			p[i] = i;
		}
	}
	
	static int find(int e) {
		if(e != p[e]) {
			p[e] = find(p[e]);
		}
		return p[e];
	}
	
	static boolean union(int f, int t) {
		int fp = find(f);
		int tp = find(t);
		
		if(fp == tp) {
			return false;
		}
		
		p[tp] = fp;
		return true;
	}

	public static void main(String[] args) {
		// 5개의 원소(0, 1, 2, 3, 4)로 집합을 초기화
        makeSet(5);

        // 원소 0과 1을 결합
        union(0, 1);
        // 원소 1과 2를 결합
        union(1, 2);
        // 원소 3과 4를 결합
        union(3, 4);

        // 원소 0의 루트 부모를 찾음 (0, 1, 2는 같은 집합)
        System.out.println("Root of 0: " + find(0)); // 출력: Root of 0: 0
        // 원소 1의 루트 부모를 찾음
        System.out.println("Root of 1: " + find(1)); // 출력: Root of 1: 0
        // 원소 2의 루트 부모를 찾음
        System.out.println("Root of 2: " + find(2)); // 출력: Root of 2: 0
        // 원소 3의 루트 부모를 찾음
        System.out.println("Root of 3: " + find(3)); // 출력: Root of 3: 3
        // 원소 4의 루트 부모를 찾음
        System.out.println("Root of 4: " + find(4)); // 출력: Root of 4: 3

        // 원소 0과 3의 루트 부모를 비교하여 서로 다른 집합인지 확인
        System.out.println("Are 0 and 3 in the same set? " + (find(0) == find(3))); // 출력: false

        // 원소 2와 3을 결합
        union(2, 3);

        // 결합 후 다시 루트 부모를 확인
        System.out.println("Root of 3 after union with 2: " + find(3)); // 출력: Root of 3: 0
        System.out.println("Are 0 and 3 in the same set now? " + (find(0) == find(3))); // 출력: true
	}
}