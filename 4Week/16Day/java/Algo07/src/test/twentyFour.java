package test;

public class twentyFour {
	public String[] solution(String[] str_list) {
		int count = 0;
		boolean left = false, right = false;
		
		for(int i = 0; i < str_list.length; i++) {
			if(str_list[i].equals("l")) {
				count = i;
				left = true;
				break;
			}else if (str_list[i].equals("r")) {
				count = i;
				right = true;
				break;
			}
		}
		
		if(left) {
			String[] answer = new String[count];
			for(int i = 0; i < count; i++) {
				answer[i] = str_list[i];
			}
            return answer;
		}else if(right){
			String[] answer = new String[str_list.length - count - 1];
			int n = 0;
			for(int i = count + 1; i < str_list.length; i++) {
				answer[n++] = str_list[i];
			}
			return answer;
		}
		return new String[] {};
    }
}
