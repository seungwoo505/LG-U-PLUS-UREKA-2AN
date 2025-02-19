import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StrLen {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(br.readLine().length());
        }catch(IOException e){

        }
    }
}