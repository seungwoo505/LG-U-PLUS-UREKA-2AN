import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int a = scan.nextInt();
        int b = scan.nextInt();

        StringBuilder sb = new StringBuilder();

        int c = gcd(a, b);

        sb.append(c)
          .append("\n")
          .append((a * b) / c);

        System.out.println(sb);

    }

    static int gcd(int a, int b){
        if(b == 0){
            return a;
        }else{
            return goc(b, a % b);
        }
    }
}