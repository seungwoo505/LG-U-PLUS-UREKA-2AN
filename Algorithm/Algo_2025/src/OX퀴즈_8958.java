import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OX퀴즈_8958 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			String[] S = br.readLine().split("");
			int total = 0;
			int O = 0;
			for(String s : S) {
				O = s.equals("O") ? O + 1 : 0;
				total += O;
			}
			sb.append(total)
			  .append("\n");
		}
		System.out.println(sb);
	}
}