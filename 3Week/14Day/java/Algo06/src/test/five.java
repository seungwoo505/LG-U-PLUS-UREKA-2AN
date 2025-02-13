package test;

public class five {
	public int[] solution(int[] arr, int n) {
        int[] answer = new int[arr.length];
        boolean a = arr.length % 2 == 0; 
        for(int i = 0; i < arr.length; i++){
            if(i % 2 == 0){
                if(a){
                    answer[i] = arr[i];
                }else{
                    answer[i] = arr[i] + n;
                }
            }else{
                if(a){
                    answer[i] = arr[i] + n;
                }else{
                    answer[i] = arr[i];
                }
            }
        }
        return answer;
    }
}
