import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Max2 {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int max = -1;
            int[] point = {0, 0};

            for(int i = 0; i < 9; i++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j < 9; j++){
                    int test = Integer.parseInt(st.nextToken());
                    if(max < test){
                        max = test;
                        point[0] = i+1;
                        point[1] = j+1;
                    }
                }
            }

            System.out.println(max);
            System.out.println(point[0] + " " + point[1]);
        }catch(IOException e){
        }
    }
}
