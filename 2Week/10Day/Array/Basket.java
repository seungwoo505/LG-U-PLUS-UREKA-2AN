import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Basket {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

            int[] basket = new int[N];

            for(int i = 0; i < N; i++){
                basket[i] = i + 1;
            }

            for(int k = 0; k < M; k++){
                st = new StringTokenizer(br.readLine(), " ");

                int i = Integer.parseInt(st.nextToken())-1, j = Integer.parseInt(st.nextToken());

                int[] basket2 = Arrays.copyOfRange(basket, i, j);

                for(int q = i, b = basket2.length-1; q < j; q++, b--){
                    basket[q] = basket2[b];
                }
            }

            StringBuilder sb = new StringBuilder(N*2);

            for(int i = 0; i < N; i++){
                sb.append(basket[i] + " ");
            }

            sb.deleteCharAt(sb.length()-1);

            System.out.println(sb);
        }catch(IOException e){
        }
    }
}
