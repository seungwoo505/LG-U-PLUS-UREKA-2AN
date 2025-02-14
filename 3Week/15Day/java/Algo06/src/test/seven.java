package test;

public class seven {
	public int solution(int[][] arr) {
		int len = arr.length;
		for(int i = 0; i < len; i++) {
			for(int j = 0; j < len; j++) {
				if(arr[i][j] != arr[j][i]) {
					return 0;
				}
			}
		}
		return 1;
    }
}
