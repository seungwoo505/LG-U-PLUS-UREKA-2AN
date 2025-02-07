import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BallChange {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

            Map<Integer, Integer> map = new HashMap<>();

            for(int i = 1; i <= N; i++){
                map.put(i, i);
            }

            for(int l = 0; l < M; l++){
                st = new StringTokenizer(br.readLine(), " ");
                int i = Integer.parseInt(st.nextToken()), j = Integer.parseInt(st.nextToken());

                int change = map.get(i);

                map.put(i, map.get(j));
                map.put(j, change);
            }

            StringBuffer sb = new StringBuffer(N*2);

            for(int i = 1; i <= N; i++){
                sb.append(map.get(i) + " ");
            }

            sb.deleteCharAt(sb.length()-1);

            System.out.println(sb);

        }catch(IOException e){
            
        }
    }
}
