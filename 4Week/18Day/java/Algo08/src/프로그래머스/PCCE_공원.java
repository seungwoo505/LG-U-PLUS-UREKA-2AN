package 프로그래머스;

import java.util.Arrays;

public class PCCE_공원 {
	public int solution(int[] mats, String[][] park) {
		int answer = -1;
		
        for(int i = 0; i < park.length; i++) {
        	for(int j = 0; j < park[i].length; j++) {
        		
        		if(park[i][j].equals("-1")) {
        			for(int mat : mats) {
        				if( mat > answer  && maxMat(mat, new int[] {i, j}, park)) {
        					answer = mat;
        				}
        			}
        		}
        	}
        }
        return answer;
    }
	
	public boolean maxMat(int mat, int[] startPos, String[][] park) {
		if(startPos[0] + mat > park.length || startPos[1] + mat > park[0].length) {
			return false;
		}
		
		for(int i = startPos[0]; i < startPos[0] + mat ; i++) {
			for(int j = startPos[1]; j < startPos[1] + mat; j++) {
				if(!park[i][j].equals("-1")) {
					return false;
				}
			}
		}
		
		return true;
	}
}
