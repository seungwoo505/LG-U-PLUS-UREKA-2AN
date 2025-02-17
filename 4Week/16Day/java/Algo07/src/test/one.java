package test;

import java.util.ArrayList;
import java.util.Arrays;

public class one {

	public String solution(String my_string, int[] indices) {
        StringBuilder answer = new StringBuilder();
        ArrayList<String> str = new ArrayList<>(Arrays.asList(my_string.split("")));
        
        Arrays.sort(indices);
        
        for(int i = 0; i < indices.length; i++){
            str.remove(indices[i] - i);
        }
        
        for(String s : str) {
        	answer.append(s);
        }
        
        return answer.toString();
    }

}
