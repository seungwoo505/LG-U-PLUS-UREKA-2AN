import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 블랙잭 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        int[] card = new int[N];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++){
            card[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;

        for(int i = 0; i < N - 2; i++){
            for(int j = i + 1; j < N - 1; j++){
                for(int k = j + 1; k < N; k++){
                    int sum = card[i] + card[j] + card[k];
                    if(sum <= M) max = Max(M, max, sum);
                }
            }
        }

        System.out.println(max);
    }

    public static int Max(int M, int max, int newMax){
        return ((M - max) < (M - newMax) ? max : newMax);
    }
}
