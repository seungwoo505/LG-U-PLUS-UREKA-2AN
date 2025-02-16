public class twelve {
    public String[] solution(String[] quiz) {
        String[] OX = new String[quiz.length];

        for(int i = 0; i < quiz.length; i++){
            String[] q = quiz[i].split(" ");

            if(q[1].equals("+")){
                OX[i] = (Integer.parseInt(q[0]) + Integer.parseInt(q[2]) == Integer.parseInt(q[4])) ? "O" : "X";
            }else {
                OX[i] = (Integer.parseInt(q[0]) - Integer.parseInt(q[2]) == Integer.parseInt(q[4])) ? "O" : "X";
            }
        }

        return OX;
    }
}
