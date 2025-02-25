import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 알파벳찾기_10809 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] answer = new int[26];
		
		String[] az = br.readLine().split("");
		
		for(int i = 0; i < 26; i++) {
			answer[i] = -1;
		}
		
		for(int i = 0; i < az.length; i++) {
			int cnt = az[i].charAt(0) - 97;
			if(answer[cnt] == -1) {
				answer[cnt] = i;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i : answer) {
			sb.append(i)
			  .append(" ");
		}
		
		System.out.println(sb.toString().trim());
	}
}