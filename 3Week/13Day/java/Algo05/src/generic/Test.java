package generic;

import java.awt.Button;
import java.util.ArrayList;
import java.util.Comparator;

public class Test {

	public static void main(String[] args) {
		int []arr1= {1,2,3}; // homogeneous collection
		String []arr2= {"hello","hi","bye"};// homogeneous collection
		Object []arr3= new Object[3];//heterogeneous collection
		arr3[0]="hello";
		arr3[1]=new Test();
		arr3[2]=1;
		
		ArrayList<Integer> list=new ArrayList<>();//homogeneous collection
		list.add(1);
		list.add(new Integer(20));
		list.add(3);
		
		System.out.println(list);
		
	
		list.sort(( o1,  o2) ->  o2-o1	);//내림차순
		
		System.out.println(list);
		
		ArrayList<String> strList=new ArrayList<>();
		strList.add("전은수");
		strList.add("홍길동");
		strList.add("이영애");
		System.out.println(strList);
		
		strList.sort((o1,o2)->o1.compareTo(o2));//오름차순
		System.out.println(strList);

	}
}
