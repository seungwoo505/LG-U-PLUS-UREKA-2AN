package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Member> list = new ArrayList<>();
		
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