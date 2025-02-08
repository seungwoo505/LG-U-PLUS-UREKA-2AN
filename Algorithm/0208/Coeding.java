import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Coeding {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int N = Integer.parseInt(br.readLine());

            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < (N-4) / 4; i++){
                sb.append("long ");
            }

            sb.append("long int");

            System.out.println(sb);
        }catch(IOException e){

        }
    }
}
