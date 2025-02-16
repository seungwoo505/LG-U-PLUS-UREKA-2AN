public class eleven {
    public String solution(String polynomial) {
        int x = 0;
        int number = 0;
        polynomial = polynomial.replace(" + ", " ");
        String[] str = polynomial.split(" ");

        for(String s : str){

            if(s.indexOf("x") != -1){
                s = s.replace("x", "");
                if(s.equals("")){
                    x += 1;
                }else{
                    x += Integer.parseInt(s);
                }
            }else {
                number += Integer.parseInt(s);
            }
        }

        if(number == 0){
            if(x <= 1){
                return "x";
            }else{
                return x + "x";
            }
        }else if(x == 0){
            return "" + number;
        }else{
            if(x <= 1){
                return "x + " + number;
            }else{
                return x + "x + " + number;
            }
        }
    }
}