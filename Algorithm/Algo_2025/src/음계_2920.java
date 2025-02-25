import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 음계_2920 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String[] ascending = {"1", "2", "3", "4", "5", "6", "7", "8"};
		String[] descending = {"8", "7", "6", "5", "4", "3", "2", "1"};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] answer = br.readLine().split(" ");
		
		System.out.println(Arrays.equals(answer, ascending) ? "ascending" : Arrays.equals(answer, descending) ? "descending" : "mixed");
	}

}