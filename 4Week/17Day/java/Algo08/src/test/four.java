package test;

import java.util.ArrayList;

public class four {
	public int solution(int[] rank, boolean[] attendance) {
        
        ArrayList<Integer[]> player = new ArrayList<>();
        
        for(int i = 0; i < rank.length; i++) {
        	if(attendance[i]) {
        		player.add(new Integer[] {rank[i], i});
        	}
        }
        
        player.sort((n1, n2) -> n1[0] - n2[0]);
        
        int a = player.get(0)[1];
        int b = player.get(1)[1];
        int c = player.get(2)[1];
                
        return 10000 * a + 100 * b + c;
    }
}
