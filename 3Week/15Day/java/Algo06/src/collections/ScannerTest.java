package collections;

import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요 : ");
		int i = scan.nextInt();
		
		System.out.println("받았습니다 :" + i);
		
		System.out.print("실수를 입력하세요 : ");
		double d = scan.nextDouble();
		
		System.out.println("받았습니다 :" + d);
		scan.nextLine();
		
		System.out.print("이름을 입력하세요 : ");
		String s = scan.nextLine();
		
		System.out.println("받았습니다 :" + s);
		
		scan.close();
	}

}
