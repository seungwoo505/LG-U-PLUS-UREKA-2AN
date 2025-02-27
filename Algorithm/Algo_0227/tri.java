import java.util.*;
public class tri {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(true){
            int a = scan.nextInt(), b = scan.nextInt(), c = scan.nextInt();
            if(a == 0 && b == 0 && c == 0) break;
        
            System.out.println(Math.pow(a, 2) * Math.pow(b, 2) == Math.pow(c, 2) ? "right" : "wrong");
        }
    }
}