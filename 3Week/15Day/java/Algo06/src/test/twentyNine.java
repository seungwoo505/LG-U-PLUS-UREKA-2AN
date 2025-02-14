package test;

public class twentyNine {
	public String solution(String my_string, int m, int c) {
		String[] str = my_string.split("");
		StringBuilder sb = new StringBuilder();
		
		for(int i = c - 1; i < str.length; i += m) {
			sb.append(str[i]);
		}
		return sb.toString();
    }
}
