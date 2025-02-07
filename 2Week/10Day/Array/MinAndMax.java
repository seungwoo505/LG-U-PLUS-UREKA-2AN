import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MinAndMax {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int min = 1000001, max = -1000001;

            for(int i = 0; i < N; i++){
                int test = Integer.parseInt(st.nextToken());
                min = Math.min(min, test);
                max = Math.max(max, test);
            }

            System.out.println(min + " " + max);
        }catch(IOException e){

        }
    }
}
