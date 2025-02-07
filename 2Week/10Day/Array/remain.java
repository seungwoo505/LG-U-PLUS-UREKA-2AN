import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class remain {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            Set set = new HashSet<>();

            for(int i = 0; i < 10; i++){
                set.add(Integer.parseInt(br.readLine()) % 42);
            }

            System.out.println(set.size());
        }catch(IOException e){

        }
    }
}
