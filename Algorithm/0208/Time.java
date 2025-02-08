import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class time {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int H = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

            int timer = Integer.parseInt(br.readLine());

            int timer_H = timer / 60, timer_M = timer % 60;

            M += timer_M;

            if(M >= 60){
                M -= 60;
                H += 1;
            }
            
            H += timer_H;

            H = H % 24;

            System.out.println(H + " " + M);
        }catch(IOException e){
            
        }
    }
}
