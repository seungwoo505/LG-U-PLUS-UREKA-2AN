import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class x {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int N = Integer.parseInt(st.nextToken()), X = Integer.parseInt(st.nextToken());

            StringBuilder str = new StringBuilder(N*2);

            st = new StringTokenizer(br.readLine(), " ");

            for(int i = 0; i < N; i++){
                int test = Integer.parseInt(st.nextToken());
                if(test < X) str.append(test + " ");

            }
            str = str.deleteCharAt(str.length() - 1);
            System.out.println(str);
        }catch (IOException e){

        }
    }
}