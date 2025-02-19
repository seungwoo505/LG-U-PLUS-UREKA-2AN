import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_10250_ACM호텔 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < T; i++){

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int H = Integer.parseInt(st.nextToken()), W = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());

            boolean[][] room = new boolean[H][W];

            for(int n = 0; n < N; n++){
                boolean get = false;
                for(int j = 1; j <= room[0].length; j++){
                    for(int k = 1; k <= room.length; k++){
                        if(!room[k-1][j-1]){
                            if(n == N - 1){
                                sb.append(k).append(j >= 10 ? j : "0").append(j < 10 ? j : "").append("\n");
                            }
                            room[k-1][j - 1] = true;
                            get = true;
                            break;
                        }
                    }
                    if(get){
                        break;
                    }
                }
            }
        }
        System.out.print(sb);
    }
}
