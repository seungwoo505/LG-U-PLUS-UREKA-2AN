package String;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = new String("java"); //시간복잡도 O(n), 공간복잡도 상승
		String s2 = "java"; // 시간복잡도 O(1), 공간복잡도 저하 <- 이 코드가 더 좋은 코드
		StringBuffer s3 = new StringBuffer("java"); //동시성 문제 있을 때 사용
		StringBuilder s4 = new StringBuilder("java"); //동시성 문제 없을 때 사용
		
		System.out.println(s1==s2);
	}

}

