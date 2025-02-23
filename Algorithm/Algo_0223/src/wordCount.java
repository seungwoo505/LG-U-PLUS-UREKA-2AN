import java.io.BufferedReader;
import java.io.InputStreamReader;

public class wordCount {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().trim().split(" ");
		int answer = 0;
		
		for(String s : str) {
			if(!s.equals("")) {
				answer++;
			}
		}
		
		System.out.println(answer);
	}

}