import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 숫자의개수_2577 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int A = Integer.parseInt(br.readLine()), B = Integer.parseInt(br.readLine()), C = Integer.parseInt(br.readLine());
		
		String[] answer = Long.toString((long)(A * B * C)).split("");
		int[] count = new int[10];
		
		for(String s : answer) {
			count[Integer.parseInt(s)]++;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < 10; i++) {
			sb.append(count[i])
			  .append("\n");
		}
		
		System.out.print(sb);
	}

}
