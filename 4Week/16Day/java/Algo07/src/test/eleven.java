package test;

public class eleven {
	public int[] solution(int[] arr, int[][] queries) {
        for(int[] i : queries) {
        	int a = arr[i[0]];
        	arr[i[0]] = arr[i[1]];
        	arr[i[1]] = a;
        }
        
        return arr;
    }
}
