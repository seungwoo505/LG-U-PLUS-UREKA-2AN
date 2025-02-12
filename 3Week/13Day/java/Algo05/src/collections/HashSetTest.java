package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Member> set = new HashSet<>();
		
		Member m1 = new Member("이승우", 20);
		Member m2 = new Member("홍길동", 10);
		Member m3 = new Member("이영애", 45);
		Member m4 = new Member("이승우", 20);
		
		set.add(m1);
		set.add(m2);
		set.add(m3);
		set.add(m4);
		
		System.out.println(set.size());
		System.out.println(set);
		
		List<Member> list = new ArrayList<>(set);
		
		Collections.sort(list); // set은 sort 할 수 없음
		
		System.out.println(list);
	}

}