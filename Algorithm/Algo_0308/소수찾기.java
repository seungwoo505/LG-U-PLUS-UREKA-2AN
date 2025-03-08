import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 소수찾기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Integer> decimal = new ArrayList<>();

        for(int i = 2; i <= 1000; i++){
            boolean isDecimal = true;

            for(int j = 2; j < i; j++){
                if(i % j == 0){
                    isDecimal = false;
                    break;
                }
            }

            if(isDecimal){
                decimal.add(i);
            }
        }

        int count = 0;

        String[] num = br.readLine().split(" ");

        for(String s : num){
            if(decimal.contains(Integer.parseInt(s))){
                count++;
            }
        }

        System.out.println(count);
    }
}
