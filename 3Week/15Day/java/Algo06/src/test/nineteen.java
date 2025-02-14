package test;

public class nineteen {
	public int solution(int[] num_list) {
		StringBuilder s1 = new StringBuilder();
		StringBuilder s2 = new StringBuilder();
		
		for(int i : num_list) {
			if( i % 2 == 0) {
				s1.append(i);
			}else {
				s2.append(i);
			}
		}
		
		return Integer.parseInt(s1.toString()) + Integer.parseInt(s2.toString());
    }
}
