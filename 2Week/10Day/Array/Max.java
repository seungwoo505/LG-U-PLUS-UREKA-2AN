import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Max {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int max = -1;
            int index = 0;

            for(int i = 1; i <= 9; i++){
                int test = Integer.parseInt(br.readLine());
                
                if (test > max){
                    max = test;
                    index = i;
                }
            }

            System.out.println(max + "\n" + index);
        }catch(IOException e){

        }
    }
    
}
