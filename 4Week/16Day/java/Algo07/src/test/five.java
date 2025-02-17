package test;

public class five {
	public int[] solution(int[] arr) {
		int pow = -1;
		int len = arr.length;
		
		while(len > Math.pow(2, ++pow));
		
        int[] answer = new int[(int) Math.pow(2, pow)];
        
        for(int i = 0; i < arr.length; i++) {
        	answer[i] = arr[i];
        }
        
        return answer;
    }
}
