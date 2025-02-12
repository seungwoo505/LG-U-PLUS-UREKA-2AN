package collections;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Member> set = new TreeSet<>();
		
		Member m1 = new Member("이승우", 20);
		Member m2 = new Member("홍길동", 10);
		Member m3 = new Member("이영애", 45);
		Member m4 = new Member("이승우", 20);
		
		set.add(m1);
		set.add(m2);
		set.add(m3);
		set.add(m4);
		
		System.out.println(set.size());
		System.out.println(set); // 정렬을 안해도 자동으로 정렬됨
	}
}