import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 벌집 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()) - 1;

        int n = 1;
        
        while(N > 0){
            N -= 6 * n++;
        }

        System.out.println(n);
    }
}
