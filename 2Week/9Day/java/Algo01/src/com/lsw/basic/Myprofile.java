package com.lsw.basic;

import java.util.Date;

public class Myprofile {
	public static void main(String[] args) {
		int age = 20;
		double tall = 180.2;
		char gender = '남';
		boolean isPretty = true;
		
		String name = "이승우";
		//String name = new String("이승우"); //원래는 이런 식으로 작성해야함
		
		//MyDate birthday = new MyDate();
		Date birthday = new Date(1999, 4, 05);
		
		System.out.println(age);
		System.out.println(tall);
		System.out.println(gender);
		System.out.println(isPretty);
		System.out.println(name);
		System.out.println(name.toString()); // 둥 다 동일한 작업 toString() 생략해도 상관없음 (유저가 만든게 아니라면 이런식으로 toStirng()을 생락해도 자동으로 입력한것으로 생각함)
		//System.out.println(birthday.year + "년 "+birthday.month+"월 "+birthday.day+"일");
		System.out.println(birthday.getYear());
	}

}
