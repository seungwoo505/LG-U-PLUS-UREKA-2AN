import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_31403_abc {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine()), b = Integer.parseInt(br.readLine()), c = Integer.parseInt(br.readLine());

        System.out.println(a + b - c);
        System.out.println( Integer.parseInt(a + "" + b) - c);
        br.close();
    }
}
