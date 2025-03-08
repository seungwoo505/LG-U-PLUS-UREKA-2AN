import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Hashing {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        char[] hash = br.readLine().toCharArray();

        long num = 0;
        for(int i = 0; i < N; i++){
            num += (long)(hash[i] - 96) * Math.pow(31, i);
        }

        System.out.println(num % 1234567891);
    }
}