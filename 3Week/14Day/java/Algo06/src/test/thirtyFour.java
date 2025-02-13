package test;

import java.util.Arrays;

public class thirtyFour {
	public String[] solution(String my_string) {
		
        String[] strings = my_string.split("");
        
        String[] str = new String[strings.length];
        int count = 0;
        String s = "";
        
        for(int i = strings.length-1; i >= 0; i--) {
        	s = strings[i] + s;
        	
        	str[count++] = s;
        }

        Arrays.sort(str);

        return str;
    }
}
