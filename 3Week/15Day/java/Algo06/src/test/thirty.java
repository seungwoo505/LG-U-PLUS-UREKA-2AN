package test;

public class thirty {
	public int[] solution(int[] arr, int[][] queries) {
		for(int[] querie : queries) {
			for(int i = querie[0]; i <= querie[1]; i++) {
				arr[i]++;
			}
		}
        return arr;
    }
}
