package test;

import java.util.ArrayList;

public class fourteen {
	public String[] solution(String myStr) {
		String str = myStr.replace("a", " ").replace("b", " ").replace("c", " ").trim();
		
		if(str.equals("")) {
			return new String[] {"EMPTY"};
		}
		
		ArrayList<String> list = new ArrayList<>();
		
		for(String s : str.split(" ") ) {
			if(!s.equals("")) {
				list.add(s);
			}
		}
		
		String[] answer = new String[list.size()];
		
		for(int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
		
		
        return answer;
    }
}
