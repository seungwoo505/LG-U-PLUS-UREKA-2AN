package 프로그래머스;

import java.util.Arrays;

public class 가장큰수 {
	public String solution(int[] numbers) {
		String[] strings = new String[numbers.length];
		
		for(int i = 0; i < numbers.length; i++) {
			strings[i] = String.valueOf(numbers[i]);
		}
		
		Arrays.sort(strings, (t1, t2) -> {
			String s1 = t1.toString();
			String s2 = t2.toString();
			if(s1.charAt(0) != s2.charAt(0)) {
				return s1.charAt(0) - s2.charAt(0); 
			}else {
				
			}
		});
    }
}
