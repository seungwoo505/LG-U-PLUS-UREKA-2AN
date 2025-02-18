package 순열_조합_부분집합;

import java.util.Arrays;

public class 경주 {

	static int totalCnt, n;
	static String[] result;
	static boolean[] isSelected = new boolean[30];
	static String[] person = { "김용연", "안정은", "김준서", "염승아", "황주경",
							   "최민석", "김민석", "김현우A", "김소은", "김민서",
							   "김예지", "심영민", "홍성현", "박용규", "백세진",
							   "송은재", "이예은", "최영준", "한여준", "홍석준",
							   "양세현", "김현훈", "이민규", "임재찬", "이승우",
							   "유동석", "강예슬", "이채민", "박지원", "김현우B"
							 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		n = 5;
		result = new String[n]; // 1등 ~ 5등
		
		등수정하기(0);
		System.out.println(totalCnt);
	}
	
	private static void 등수정하기(int cnt) {
		// TODO Auto-generated method stub
		if(cnt == n) {
			System.out.println(Arrays.toString(result));
			totalCnt++;
			return;
		}
		
		for(int i = 0; i < 30; i++) {
			if(isSelected[i]) continue;
			result[cnt] = person[i];
			isSelected[i] = true;
			등수정하기(cnt + 1);
			isSelected[i] = false;
		}
	}

}
