package test;

public class fortySeven {
	public int solution(String binomial) {
		String[] math = binomial.split(" ");
		
		if(math[1].equals("+")) {
			return Integer.parseInt(math[0]) + Integer.parseInt(math[2]);
		}else if(math[1].equals("-")) {
			return Integer.parseInt(math[0]) - Integer.parseInt(math[2]);
		}else {
			return Integer.parseInt(math[0]) * Integer.parseInt(math[2]);
		}
    }
}
