package 프로그래머스;

import java.util.ArrayList;
import java.util.List;

class 하노이의탑 {
    static List<int[]> list = new ArrayList<>();

    public int[][] solution(int n) {
        hanoi(n, 1, 2, 3);
        int[][] answer = new int[list.size()][2];

        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }

    public void hanoi(int n, int start, int mid, int end){
        if(n == 1){
            list.add(new int[]{start, end});
        }else{
            hanoi(n - 1, start, end, mid);
            list.add(new int[]{start, end});
            hanoi(n - 1, mid, start, end);
        }


    }
}