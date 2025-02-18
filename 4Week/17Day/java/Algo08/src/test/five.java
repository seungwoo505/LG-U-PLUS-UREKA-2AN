package test;

import java.util.Scanner;

public class five {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        StringBuffer sb = new StringBuffer();
        
        for(String s : a.split("")) {
        	if(s.equals(s.toLowerCase())) {
        		sb.append(s.toUpperCase());
        	}else {
        		sb.append(s.toLowerCase());
        	}
        }
        System.out.println(sb.toString());
    }
}
