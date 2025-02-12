package collections;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Member> list = new LinkedList<>();
		
		Member m1 = new Member("이승우", 20);
		Member m2 = new Member("홍길동", 10);
		Member m3 = new Member("이영애", 45);
		
		list.add(m1);
		list.add(m2);
		list.add(m3);
		
		System.out.println(list.size());
		System.out.println(list);
		
		Collections.sort(list);
		
		System.out.println(list);
	}

}