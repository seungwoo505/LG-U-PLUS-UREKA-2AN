package test;

public class twentyThree {
	public int[] solution(int[] num_list, int n) {
        int[] answer = new int[num_list.length / n + (num_list.length % n == 0 ? 0 : 1)];
        int count = 0;
        for(int i = 0; i < num_list.length; i = i + n) {
        	answer[count++] = num_list[i];
        }
        return answer;
    }
}
