package generic;

import java.awt.Button;
import java.util.ArrayList;
import java.util.Comparator;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {1, 2, 3}; // homogeneous collection
		String[] arr2 = {"hello", "h1", "bye"}; // homogeneous collection
		
		Object[] arr3 = new Object[3]; //heterogeneous collection
		arr3[0] = "hello";
		arr3[1] = new Test();
		arr3[2] = 1; // 원래는 사용할 수 없으나 new Integer(1)로 인식해서 넣어준다.
		
		for(Object o : arr3) {
			System.out.println(o);
		}
		
		ArrayList list = new ArrayList();
		
		list.add(1);
		list.add(new Test());
		list.add("hello");
		
		for(Object o : list) {
			if(o instanceof Integer) {
				System.out.println(o);
			}
		}
		
		
		ArrayList<Integer> list2 = new ArrayList();
		
		list2.add(1);
		list2.add(new Integer(20));
		list2.add(3);
		
		System.out.println(list2);
		
		list2.sort((o1, o2) -> o1-o2); // 메서드가 한줄이고 return 한 줄이라면 생략가능 (성능 향상보단 가독성을 위해 사용)
		System.out.println(list2);
	}
}