import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class count {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int first = Integer.parseInt(br.readLine());

            int[] arr = new int[first];
            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            for(int i = 0; i < first; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int target = Integer.parseInt(br.readLine());

            int count = 0;

            for(int i : arr){
                if(i == target) count++;
            }

            System.out.println(count);
        }catch(IOException e){
            
        }
    }
}
