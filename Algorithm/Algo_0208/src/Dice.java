import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Dice {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] s = br.readLine().split(" ");

            int[] dice = new int[3];

            for(int i = 0; i < 3; i++){
                dice[i] = Integer.parseInt(s[i]);
            }

            int choice = 0;
            int count = 0;
            Arrays.sort(dice);

            for(int i : dice){
                if(choice == i) count++;
                else if(count <= 1){
                    choice = i;
                    count = 1;
                }
            }

            System.out.println((count == 3 ? 10000 : count == 2 ? 1000 : 0) + choice * (count == 3 ? 1000 : 100));
        }catch(IOException e){

        }
    }
}
