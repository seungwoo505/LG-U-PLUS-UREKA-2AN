public class fifteen {
    public int solution(int[][] board) {
        int len = board.length;
        int[][] freeZone = new int[len][len];

        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                if(board[i][j] == 1){
                    for(int x = i - 1; x <= i + 1; x++){
                        if(x < 0){
                            x = 0;
                        }

                        if(x >= len){
                            break;
                        }
                        for(int y = j - 1; y <= j + 1; y++){
                            if(y < 0){
                                y = 0;
                            }
    
                            if(y >= len){
                                break;
                            }

                            freeZone[x][y] = 1;
                        }
                    }
                }
            }
        }

        int answer = 0;

        for(int[] i : freeZone){
            for(int j : i){
                if(j == 0){
                    answer++;
                }
            }
        }
        return answer;
    }
}
