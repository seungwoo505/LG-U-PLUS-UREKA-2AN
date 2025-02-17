package test;

public class sixteen {
public int[] solution(int n, int[] slicer, int[] num_list) {
		
		int first = n == 1 ? 0 : slicer[0];
		int last = n == 2 ? num_list.length : slicer[1] + 1;
		int step = n == 4 ? slicer[2] : 1;
        int len = 0;
        for(int i = first; i < last; i += step) {
			len++;
		}
		
		int[] answer = new int[len];
		int count = 0;
		
		for(int i = first; i < last; i += step) {
			answer[count++] = num_list[i];
		}
		
        return answer;
    }
}
