package test;

public class twenty {
	public String[] solution(String[] todo_list, boolean[] finished) {
		int len = 0;
		for(boolean b : finished) {
			len += b ? 0 : 1;
		}
		
        String[] answer = new String[len];
        
        int count = 0;
        for(int i = 0; i < todo_list.length; i++) {
        	if(!finished[i]) {
        		answer[count++] = todo_list[i];
        	}
        }
        
        return answer;
    }
}
