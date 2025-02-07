import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Avg {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int first = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            double[] score = new double[first];

            double max = 0;
            
            for(int i = 0; i < first; i++){
                score[i] =  (double)Integer.parseInt(st.nextToken());
                max = Math.max(max, score[i]);
            }

            double avg = 0;

            for(int i = 0; i < first; i++){
                avg += score[i] / max * 100;
            }

            System.out.println(avg/first);

            
        }catch(IOException e){
            
        }
    }
}
