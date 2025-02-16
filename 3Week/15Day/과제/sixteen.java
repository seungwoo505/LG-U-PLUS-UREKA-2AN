import java.util.ArrayList;
import java.util.Arrays;

public class sixteen {
    public int solution(int[][] lines) {
        int answer = 0;

        int[] count = new int[201];

        for(int[] i : lines) {
            int start = i[0]+100;
            int end = i[1]+100;

            for(int k=start; k<end; k++) {
                count[k] += 1;
            }
        }
        
        for(int i : count) {
            if(i>1) answer++;
        }

        return answer;
    }
}
