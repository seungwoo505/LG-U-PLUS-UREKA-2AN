package test;

public class thirtyThree {
	public int solution(String my_string, String is_suffix) {
		String[] strings = my_string.split("");
		StringBuilder str = new StringBuilder();
		
		if(my_string.replace(str, "").equals(is_suffix)) {
			return 1;
		}
		
		for(int i = 0; i < strings.length-1; i++) {
			str.append(strings[i]);
			
			if(my_string.replace(str, "").equals(is_suffix)) {
				return 1;
			}
		}
		return 0;
    }
}
