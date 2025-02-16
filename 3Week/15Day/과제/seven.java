public class seven {
    public int[] solution(int[][] score) {
        double[] sc = new double[score.length];
        int[] answer = new int[score.length];

        for(int i = 0; i < score.length; i++){
            sc[i] = (double)(score[i][0] + score[i][1]) / 2;
        }

        for(int i = 1; i <= sc.length; i++){
            double max = 0;

            for(int j = 0; j < sc.length; j++){
                if(answer[j] != 0){
                    continue;
                }

                if(max < sc[j]){
                    max = sc[j];
                }
            }

            int count = 0;

            for(int j = 0; j < sc.length; j++){
                if(answer[j] != 0){
                    continue;
                }

                if(max == sc[j]){
                    count++;
                    answer[j] = i;
                }
            }

            i += (count - 1);
        }

        return answer;
    }
}
