public class thirteen {
    public int solution(int[] common) {
        int difference = common[1] - common[0];

        int last = common[common.length - 1] - common[common.length - 2];

        if(last == difference){
            return common[common.length - 1] + difference;
        }else{
            return common[common.length - 1] * (common[1] / common[0]);
        }
    }
}
