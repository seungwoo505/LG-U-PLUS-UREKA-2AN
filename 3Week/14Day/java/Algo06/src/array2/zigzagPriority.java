package array2;

public class zigzagPriority {
	
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
		int cols = arr[0].length;
		for(int i = 0; i < rows; i++){
			if(i % 2 == 0) {
				for(int j = 0; j < cols; j++) {
					System.out.print(arr[i][j] + " ");
				}
			}else {
				for(int j = cols - 1; j >= 0; j--) {
					System.out.print(arr[i][j] + " ");
				}
			}
			System.out.println();
		}
	}
}
