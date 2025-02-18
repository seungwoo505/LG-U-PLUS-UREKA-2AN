package test;

public class one {
	public int[] solution(int[] arr, int[][] queries) {
		int[] answer = new int[queries.length];
		int count = 0;
		for(int[] q : queries) {
			int min = 1000001;
			for(int i = q[0]; i <= q[1]; i++) {
				if(arr[i] > q[2]) {
					min = Math.min(arr[i], min);
				}
			}
			answer[count++] = min == 1000001 ? -1 : min;
		}
		return answer;
    }
}
