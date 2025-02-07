import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Assignment {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            Map<Integer, Integer> student = new HashMap<>();

            for(int i = 1; i <= 30; i++){
                student.put(i, null);
            }

            for(int i = 0; i < 28; i++){
                int index = Integer.parseInt(br.readLine());

                student.remove(index);
            }

             for(int k : student.keySet()){
                System.out.println(k);
             }
        }catch(IOException e){
            
        }
    }
}
