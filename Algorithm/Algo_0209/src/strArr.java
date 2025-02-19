import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class strArr {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());

            for(int i = 0; i < N; i++){
                String[] str = br.readLine().split("");

                System.out.println(str[0] + str[str.length-1]);
            }
        }catch(IOException e){

        }
    }   
}