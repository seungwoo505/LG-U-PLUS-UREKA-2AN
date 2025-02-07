import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Plus {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

            int[][] matrix = new int[N][M];

            for(int i = 0; i < 2; i++){
                for(int j = 0; j < N; j++){
                    st = new StringTokenizer(br.readLine(), " ");
                    for(int k = 0; k < M; k++){
                        matrix[j][k] += Integer.parseInt(st.nextToken());
                    }
                }
            }

            for(int i = 0; i < N; i++){
                StringBuilder s = new StringBuilder(M*2);
                for(int j = 0; j < M; j++){
                    s.append(matrix[i][j] + " ");
                }
                s.deleteCharAt(s.length()-1);
                System.out.println(s);
            }
        }catch(IOException e){

        }
    }
}
