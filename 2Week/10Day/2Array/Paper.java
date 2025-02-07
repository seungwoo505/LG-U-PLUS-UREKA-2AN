import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Paper {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int num = Integer.parseInt(br.readLine());
            boolean[][] page = new boolean[101][101];
            int count = 0;

            for(int i = 0; i < num; i++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());

                for(int j = y; j < y+10; j++){
                    for(int k = x; k < x+10; k++){
                        if(page[j][k]) continue;
                        page[j][k] = true;
                        count++;
                    }
                }
            }

            System.out.println(count);
        }catch(IOException e){
            
        }
    }
}