package 순열_조합_부분집합;

import java.util.Arrays;

public class 노래듀엣고르기 {
	
	static int totalCnt, n;
	static String[] result;
	static String[] person = { "김용연", "안정은", "김준서", "염승아", "황주경",
							   "최민석", "김민석", "김현우A", "김소은", "김민서",
							   "김예지", "심영민", "홍성현", "박용규", "백세진",
							   "송은재", "이예은", "최영준", "한여준", "홍석준",
							   "양세현", "김현훈", "이민규", "임재찬", "이승우",
							   "유동석", "강예슬", "이채민", "박지원", "김현우B"
							 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		n = 2;
		result = new String[n];
		
		팀원선정하기(0, 0);
		System.out.println(totalCnt);
	}
	
	private static void 팀원선정하기(int cnt, int start) {
		// TODO Auto-generated method stub
		if(cnt == n) {
			System.out.println(Arrays.toString(result));
			totalCnt++;
			return;
		}
		
		for(int i = start; i < 30; i++) {
			result[cnt] = person[i];
			팀원선정하기(cnt + 1, i + 1);
		}
	}

}
