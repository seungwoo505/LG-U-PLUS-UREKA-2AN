package test2;

public class thirteen {
	public int[] solution(int[] num_list) {
        int[] num = new int[num_list.length];
        for(int i = 0; i < num.length; i++) {
        	num[i] = num_list[num_list.length - 1 - i];
        }
        return num;
    }
}
