import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class ten {
    public int[] solution(int[] numlist, int n) {
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
        int[] answer = new int[numlist.length];
        
        for(int i : numlist){
            int difference = Math.abs(n - i);
            ArrayList<Integer> list = new ArrayList<>();
            if(map.get(difference) != null){
                list = map.get(difference);
            }

            list.add(i);
            map.put(difference, list);
        }

        int count = 0;

        for(Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()){
            ArrayList<Integer> value = entry.getValue();
            value.sort((n1, n2) -> n2 - n1);

            for(Integer i : value){
                answer[count++] = i;
            }
        }

        return answer;
    }
}
