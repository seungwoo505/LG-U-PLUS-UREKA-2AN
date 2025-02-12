package collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<>();
		list.add("Apple");
		list.add("Banana");
		list.add("Orange");
		list.add("Apple");
		System.out.println(list.size());
		System.out.println(list);
		
		Set<Object> set = new HashSet<>();
		set.add("Apple");
		set.add("Banana");
		set.add("Orange");
		set.add("Apple");
		
		Member m1 = new Member("이승우", 20);
		Member m2 = new Member("이승우", 20);
		
		set.add(m1);
		set.add(m2);
		
		System.out.println(set.size());
		System.out.println(set);
		
		System.out.println(m1.hashCode());
		System.out.println(m2.hashCode());
	}

}