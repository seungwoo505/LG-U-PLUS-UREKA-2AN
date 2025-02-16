public class one{
    public int[] solution(String[] keyinput, int[] board) {
        board[0] -= 1;
        board[1] -= 1;
        
        int[] map = new int[2];
        
        for(String key : keyinput){
            if(key.equals("up")){
                if(board[1] / 2 >= map[1] + 1 ){
                    map[1] += 1;
                }
            }else if(key.equals("down")){
                if(- board[1] / 2 <= map[1] - 1 ){
                    map[1] -= 1;
                }
            }else if(key.equals("right")){
                if(board[0] / 2 >= map[0] + 1 ){
                    map[0] += 1;
                }
            }else if(key.equals("left")){
                if(- board[0] / 2 <= map[0] - 1 ){
                    map[0] -= 1;
                }
            }
        }
        return map;
    }
}