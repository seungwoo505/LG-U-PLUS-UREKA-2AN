package array2;

import java.util.Iterator;

public class rowPriority {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] array = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		
		trave(array);
	}
	
	public static void trave(int[][] arr) {
		int rows = arr.length;
		for(int i = 0; i < rows; i++){
			int cols = arr[i].length;
			for(int j = 0; j < cols; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
