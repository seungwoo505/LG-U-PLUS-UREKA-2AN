import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class remain {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            Map<Integer, Integer> map = new HashMap<>();

            for(int i = 0; i < 10; i++){
                map.put(Integer.parseInt(br.readLine()) % 42, null);
            }

            System.out.println(map.size());
        }catch(IOException e){

        }
    }
}
