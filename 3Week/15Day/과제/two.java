public class two {
    public int solution(String[] spell, String[] dic) {
        for(String str : dic){
            int count = 0;
            for(String s : spell){
                if(str.indexOf(s) == -1){
                    break;
                }else {
                    count++;
                }
            }

            if(count == spell.length){
                return 1;
            }
        }
        return 2;
    }
}
