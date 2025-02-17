package test;

public class twentyOne {
	public int[] solution(int[] arr, int[][] queries) {
		for(int[] q : queries) {
			for(int i = q[0]; i <= q[1]; i++) {
				if(i % q[2] == 0) {
					arr[i]++;
				}
			}
		}
        return arr;
    }
}
