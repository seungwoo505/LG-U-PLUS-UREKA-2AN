import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 웰컴키트 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] size = new int[6]; // S, M, L, XL, XXL, XXXL

        for(int i = 0; i < 6; i++) {
            size[i] = Integer.parseInt(st.nextToken());
        } 

        st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken()), P = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        int bundle = 0;

        for(int i = 0; i < 6; i++){
            bundle += (size[i] / T) + (size[i] % T == 0 ? 0 : 1);
        }

        sb.append(bundle)
          .append("\n")
          .append(N / P)
          .append(" ")
          .append(N % P);

        System.out.println(sb);
    }
}
