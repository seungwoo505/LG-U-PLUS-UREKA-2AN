package 프로그래머스;

import java.util.ArrayList;

public class PCCE_데이터분석 {
	public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
		ArrayList<int[]> list = new ArrayList<>();
		
		for(int[] i : data) {
			if(i[ ext.equals("code") ? 0 : ext.equals("date") ? 1 : ext.equals("maximum") ? 2 : 3] < val_ext) {
				list.add(i);
			}
		}
		
		list.sort((n1, n2) -> n1[ sort_by.equals("code") ? 0 : sort_by.equals("date") ? 1 : sort_by.equals("maximum") ? 2 : 3 ] - n2[ sort_by.equals("code") ? 0 : sort_by.equals("date") ? 1 : sort_by.equals("maximum") ? 2 : 3 ]);
        int[][] answer = new int[list.size()][4];
        
        for(int i = 0; i < answer.length; i++) {
        	answer[i] = list.get(i);
        }
        return answer;
    }
}