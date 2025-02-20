package 프로그래머스;

public class 배열자르기 {

	public static int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];
        
        int cnt = 0;
        
        for(long i = left; i <= right; i++) {
        	answer[cnt++] = (int) (((i / n) >= (i % n)) ? (i / n) + 1 : (i % n) + 1);
         	
        }
        
        return answer;
    }
}