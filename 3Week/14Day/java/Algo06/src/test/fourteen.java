package test;

public class fourteen {
	public String solution(String myString) {
		String[] str = myString.split("");
		
        StringBuilder sb = new StringBuilder(myString.length());
        
        for(String s : str) {
        	sb.append(s.toLowerCase());
        }
        return sb.toString();
    }
}
