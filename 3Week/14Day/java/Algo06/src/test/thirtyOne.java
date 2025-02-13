package test;

public class thirtyOne {
	public int solution(String my_string, String is_prefix) {
		String[] strings = my_string.split("");
		String str = "";
		
		for(String s : strings) {
			str += s;
			if(str.equals(is_prefix)) {
				return 1;
			}
		}
		return 0;
    }
}
