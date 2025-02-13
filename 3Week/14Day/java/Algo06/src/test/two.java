package test;

public class two {
	public int solution(String num_str) {
        String[] arr = num_str.split("");
        int answer = 0;
        for(String s : arr){
            answer += Integer.parseInt(s);            
        }
        return answer;
    }
}
