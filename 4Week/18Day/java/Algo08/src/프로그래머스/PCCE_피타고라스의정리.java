package 프로그래머스;

import java.util.Scanner;

public class PCCE_피타고라스의정리 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int c = sc.nextInt();

        int b_square = (int)Math.pow(c, 2) - (int)Math.pow(a, 2);

        System.out.println(b_square);
    }
}
