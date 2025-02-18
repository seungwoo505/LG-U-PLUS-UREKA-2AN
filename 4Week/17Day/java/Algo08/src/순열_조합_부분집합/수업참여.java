package 순열_조합_부분집합;

public class 수업참여 {

	static final int N = 30;
	static boolean[] isSelected;
	static int totalCnt;
	static String[] person = {
			   "홍성현", "이민규", "양세현", "이승우"
			 };
	//static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isSelected = new boolean[N];
		
		참여인원수(0);
		//System.out.println(sb);
	}

	private static void 참여인원수(int cnt) {
		// TODO Auto-generated method stub
		if(cnt == N) {
			++totalCnt;
			
			for(int i = 0; i < N; i++) {
				System.out.print(isSelected[i] ? person[i] : "X");
				//sb.append(isSelected[i] ? person[i] : "X");
			}
			System.out.println();
			//sb.append("\n");
			return;
		}
		
		isSelected[cnt] = true;
		참여인원수(cnt + 1);
		
		isSelected[cnt] = false;
		참여인원수(cnt + 1);
	}

}
