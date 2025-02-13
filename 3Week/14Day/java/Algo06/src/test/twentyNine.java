package test;

public class twentyNine {
	public int[] solution(int start_num, int end_num) {
        int[] answer = new int[start_num - end_num + 1];
        int count = 0;
        while(start_num >= end_num) {
        	answer[count++] = start_num--;
        }
        return answer;
    }
}
