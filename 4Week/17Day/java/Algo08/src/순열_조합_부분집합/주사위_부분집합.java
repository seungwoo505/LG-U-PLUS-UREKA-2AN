package 순열_조합_부분집합;

public class 주사위_부분집합 {

	static boolean[] isSelected;
	static int totalCnt;
	static int[] input = {1, 2, 3, 4, 5, 6};
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = System.nanoTime();
		isSelected = new boolean[6];
		
		subset(0);
		System.out.println(sb);
		long end = System.nanoTime();
		
		System.out.println(end - start); // 걸린 시간 보는 방법
	}

	private static void subset(int cnt) {
		// TODO Auto-generated method stub
		if(cnt == 6) {
			++totalCnt;
			
			for(int i = 0; i < 6; i++) {
				//System.out.print((isSelected[i] ? input[i] : "X") + " ");
				sb.append(isSelected[i] ? input[i] : "X");
			}
			//System.out.println();
			sb.append("\n");
			return;
		}
		
		isSelected[cnt] = true;
		subset(cnt + 1);
		
		isSelected[cnt] = false;
		subset(cnt + 1);
	}

}
