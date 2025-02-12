package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Member> map = new HashMap<>();
		
		Member m1 = new Member("이승우", 20);
		Member m2 = new Member("홍길동", 10);
		Member m3 = new Member("이영애", 45);
		Member m4 = new Member("이승우", 20);
		
		map.put(m1.getName(), m1);
		map.put(m2.getName(), m2);
		map.put(m3.getName(), m3);
		map.put(m4.getName(), m4);
		
		System.out.println(map.size());
		System.out.println(map);
	}

}