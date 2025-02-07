package com.lsw.basic;

import java.util.Date;

public class MyProfile {
	private int age;
	public double tall = 180.2;
	public char gender = '남';
	public boolean isPretty = true;
	
	public String name = "이승우";
	
	public Date birthday = new Date(1999, 4, 05);

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if(age > 0) this.age = age;
		else System.out.println("유효 범위 아님");
	}
	
	

}
