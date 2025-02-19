import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class receipt {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int total = Integer.parseInt(br.readLine());
            int num = Integer.parseInt(br.readLine());

            int total_price = 0;

            for(int i = 0; i < num; i++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int price = Integer.parseInt(st.nextToken()), count = Integer.parseInt(st.nextToken());
                total_price += price * count;
            }

            System.out.println(total == total_price ? "Yes" : "No");
        }catch(IOException e){

        }
    }
}
