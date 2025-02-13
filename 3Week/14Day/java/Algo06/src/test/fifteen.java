package test;

public class fifteen {
	public String solution(String myString) {
		String[] str = myString.split("");
		
        StringBuilder sb = new StringBuilder(myString.length());
        
        for(String s : str) {
        	sb.append(s.toUpperCase());
        }
        return sb.toString();
    }
}
