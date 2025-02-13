package test;

import java.util.Scanner;

public class fortyFour {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        for(String s : a.split("")) {
        	System.out.println(s);
        }
    }
}
