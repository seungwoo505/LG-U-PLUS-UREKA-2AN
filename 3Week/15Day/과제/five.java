public record five() {
    public String solution(String[] id_pw, String[][] db) {
        for(String[] login : db){
            if(login[0].equals(id_pw[0])){
                if(login[1].equals(id_pw[1])){
                    return "login";
                }else{
                    return "wrong pw";
                }
            }
        }
        return "fail";
    }
}
