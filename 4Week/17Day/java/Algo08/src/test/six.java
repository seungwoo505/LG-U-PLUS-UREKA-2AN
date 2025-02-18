package test;

public class six {
	public String solution(String code) {
        String mode = "0";
        StringBuilder answer = new StringBuilder();
        String[] str = code.split("");
        
        for(int i = 0; i < str.length; i++){
            if(mode.equals("0")){
                if(!str[i].equals("1") && i % 2 == 0){
                    answer.append(str[i]);
                }else if(str[i].equals("1")){
                    mode = "1";
                }
            }else{
                if(!str[i].equals("1") && i % 2 != 0){
                    answer.append(str[i]);
                }else if(str[i].equals("1")){
                    mode = "0";
                }
            }
        }
        String s = answer.toString();
        return s.equals("") ? "EMPTY" : s;
    }
}
