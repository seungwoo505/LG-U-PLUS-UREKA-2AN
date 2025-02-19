package Tree;

import java.util.*;

public class SetPerformanceComparison {

    public static void main(String[] args) {
    	
    	/**
    	 * TreeSet이 7.9S
    	 * HashSet이 2.7S
    	 * 
    	 * HashSet이 압도적으로 빠름
    	 * 
    	 * 다만 이 조건은 삽입하고 정렬까지의 시간
    	 * 
    	 * 만약 삽입이 없다면 당연히 TreeSet이 빠름
    	 */
    	
        // 데이터 개수
        int n = 10000000;

        // TreeSet 성능 측정
        long startTime = System.nanoTime();
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            treeSet.add((int) (Math.random() * n));
        }
        long endTime = System.nanoTime();
        System.out.println("TreeSet 삽입 시간: " + (endTime - startTime) + " ns");

        // HashSet 성능 측정
        startTime = System.nanoTime();
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            hashSet.add((int) (Math.random() * n));
        }
        // HashSet을 ArrayList로 변환 후 정렬
        List<Integer> hashList = new ArrayList<>(hashSet);
        Collections.sort(hashList);
        endTime = System.nanoTime();
        System.out.println("HashSet 삽입 및 정렬 시간: " + (endTime - startTime) + " ns");
    }
}

