package collections;

public class Member implements Comparable<Member>{
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
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return name.hashCode()+age;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return this.hashCode()==obj.hashCode();
	}
}