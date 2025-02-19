import java.io.*;
import java.util.*;

public class 백준_2475_검증수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] computer = br.readLine().split(" ");
        int answer = 0;

        for(String s : computer){
            answer += Math.pow(Integer.parseInt(s), 2);
        }

        answer %= 10;

        System.out.println(answer);
    }
}
