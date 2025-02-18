import java.util.Arrays;

public class twenty {
    public int solution(String[] babbling) {
        String[] sound = {"aya", "ye", "woo", "ma"};
        int answer = 0;

        for(String str : babbling){
            String baby = str;
            for(String s : sound){
                baby = baby.replaceAll(s, " ");
            }
            baby = baby.replace(" ", "");
            if(baby.equals("")){
                answer++;
            }
        }
        return answer;
    }
}
