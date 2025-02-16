import java.util.ArrayList;
import java.util.Arrays;

class four {
    public int solution(int[][] dots) {
        int width = 0;
        int height = 0;

        ArrayList<int[]> list = new ArrayList<>(Arrays.asList(dots));

        list.sort((i1, i2) -> {
            if(i1[0] == i2[0]){
                return i1[1] - i2[1];
            } 
            return i1[0] - i2[0];
        });
         
         
        width = list.get(2)[0] - list.get(1)[0];
        height = list.get(1)[1] - list.get(2)[1];

        return width * height;
    }
}
