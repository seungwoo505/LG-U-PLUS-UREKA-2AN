package test;

public class forty {
	public int solution(int n, String control) {
		String[] str = control.split("");
		
		for(String s : str) {
			n += s.equals("w") ? 1 : s.equals("s") ? -1 : s.equals("d") ? 10 : -10; 
		}
		return n;
    }
}
