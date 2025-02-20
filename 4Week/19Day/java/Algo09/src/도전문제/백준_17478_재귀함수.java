package 도전문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_17478_재귀함수 {
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
		for(int i = 0; i < N; i++) {
			sb.append(print(i))
			  .append("\"재귀함수가 뭔가요?\"\n")
			  .append(print(i))
			  .append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n")
			  .append(print(i))
			  .append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n")
			  .append(print(i))
			  .append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
		}
		sb.append(print(N))
		  .append("\"재귀함수가 뭔가요?\"\n")
		  .append(print(N))
		  .append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
		
		for(int i = N; i >= 0; i--) {
			sb.append(print(i))
			  .append("라고 답변하였지.\n");
		}
		
		System.out.println(sb);
	}
	
	static String print(int cnt) {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < cnt; i++) {
			sb.append("____");
		}
		
		return sb.toString();
	}

}
