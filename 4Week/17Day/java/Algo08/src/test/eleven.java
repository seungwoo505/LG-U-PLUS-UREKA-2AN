package test;

public class eleven {
	public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        
        int count = 1;
        int rowStart = 0;
        int rowEnd = n - 1;
        int colStart = 0;
        int colEnd = n - 1;
        
        
        while(count <= n * n){
            for(int i = colStart; i <= colEnd; i++){
                answer[rowStart][i] = count++;
            }
            rowStart++;
            
            for(int i = rowStart; i <= rowEnd; i++){
                answer[i][colEnd] = count++;
            }
            colEnd--;
            
            for(int i = colEnd; i >= colStart; i--){
                answer[rowEnd][i] = count++;
            }
            rowEnd--;
            
            for(int i = rowEnd; i >= rowStart; i--){
                answer[i][colStart] = count++;
            }
            colStart++;
        }
        return answer;
    }
}
