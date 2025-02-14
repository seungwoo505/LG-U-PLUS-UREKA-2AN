package test;

public class nine {
	public String solution(String n_str) {
		String[] str = n_str.split("");
		int len = 0;
		for(int i = 0; i < str.length; i++) {
			if(!str[i].equals("0")) {
				len = i;
				break;
			}
		}
		StringBuilder sb = new StringBuilder(str.length - len - 1);
		
		for(int i = len; i < str.length; i++) {
			sb.append(str[i]);
		}
		
		return sb.toString();
    }
}