import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 분해합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 1; i < N; i++){
            int sum = i + sum(i);
            if(sum == N){
                System.out.println(i);
                return;
            }
        }

        System.out.println(0);
    }

    public static int sum(int n){
        int sum = 0;

        while(n > 0){
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
