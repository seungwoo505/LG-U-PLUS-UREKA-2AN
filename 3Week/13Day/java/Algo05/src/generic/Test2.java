package generic;

import java.util.ArrayList;
import java.util.Collections;

public class Test2 {

	public static void main(String[] args) {
		ArrayList<Member> list=new ArrayList<>();
		list.add(new Member("전은수",-2147483647));
		list.add(new Member("홍길동",20));
		list.add(new Member("이영애",45));
		//list.add(new Member("전은수",20));
		//System.out.println(list);
		
		//나이 오름차순 정렬
//		list.sort((o1,o2)->o1.getAge()-o2.getAge());
//		System.out.println(list);
		
		//이름 오름차순 정렬
//		list.sort((o1,o2)->o1.getName().compareTo(o2.getName()));
//		System.out.println(list);
		
		Collections.sort(list);
		System.out.println(list);
	}

}

class Member implements Comparable<Member>{
	private String name;
	private int age;	
	
	public Member(String name, int age) {
		//super();
		setName(name);
		setAge(age);
	}
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name!=null) {
			this.name = name;
		}else {
			System.out.println("null은 불가");
		}
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age=age;
//		if(age>0 && age <=120) {
//			this.age = age;
//		}else {
//			System.out.println("나이는 0보다 크고 120보다 작아야 합니다");
//		}
	}
	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + "]";
	}
	@Override
	public int compareTo(Member o) {
		// 나이가 어린 직원부터 이름 오름차순 
		if(this.age > o.getAge()) {
			return 1;
		}else if (this.age < o.getAge()) {		
			return -1;
		}else {
			return this.name.compareTo(o.getName());
		}
		
	}
	
	
}