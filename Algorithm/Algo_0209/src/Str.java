import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Str {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] str = br.readLine().split("");
            int len = Integer.parseInt(br.readLine());

            System.out.println(str[len-1]);
        }catch(IOException e){

        }
    }
}