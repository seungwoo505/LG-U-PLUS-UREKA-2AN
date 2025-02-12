package generic;

import java.util.ArrayList;
import java.util.List;

public class Test3 {

	public static void main(String[] args) {
		List<A> list=new ArrayList<>();
//		list.add("java");
//		list.add(new String("java"));
//		list.add(new StringBuilder("java"));
//		list.add(1);
		list.add(new A());
		list.add(new B());
		
		List<B> list2=new ArrayList<>();
		list2.add(new B());
		
		Biz.service(list2);
	}

}

class A{}
class B extends A{}

class Biz{
	public static void service(List<? extends A> list) {
		for(A o:list) {
			//중요한 일...
//			if(타입 체킹) {
//				타입 캐스팅
//			}
		}
	}
}