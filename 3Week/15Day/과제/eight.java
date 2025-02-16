public class eight {
    public int solution(int n) {
        int[] num = new int[100];

        num[0] = 1;
        num[1] = 2;


        for(int i = 2; i < 100; i++){
            int x = num[i-1] + 1;
            while((x % 3 == 0) || (x + "").indexOf("3") != -1){
                x++;
            }

            num[i] = x;

        }
        return num[n-1];
    }
}
