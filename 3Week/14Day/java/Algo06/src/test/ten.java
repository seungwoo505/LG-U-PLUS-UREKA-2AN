package test;

public class ten {
	public String[] solution(String my_string) {
		String[] str = my_string.split(" ");
		int count = 0;
		
		for(String s : str) {
			if(!s.equals("")) {
				count++;
			}
		}
        String[] answer = new String[count];
        count = 0;
        for(String s : str) {
			if(!s.equals("")) {
				answer[count++] = s;
			}
		}
        
        return answer;
    }
}
