import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Ball {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

            Map<Integer, Integer> map = new HashMap<>();
            
            for(int i = 1; i <= N; i++){
                map.put(i, 0);
            }
            for(int q = 0; q < M; q++){
                st = new StringTokenizer(br.readLine(), " ");
                int i = Integer.parseInt(st.nextToken()), j = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

                for(int l = i; l <= j; l++){
                    map.put(l, k);
                }
            }

            StringBuilder str = new StringBuilder(N*2);

            for(int i = 1; i <= N; i++){
                str.append(map.get(i) + " ");
            }

            str.deleteCharAt(str.length()-1);

            System.out.println(str);
        }catch(IOException e){

        }
    }
}