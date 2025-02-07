import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Read {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] strings = new String[5];

            int maxLength = 0;

            for(int i = 0; i < 5; i++){
                strings[i] = br.readLine();
                maxLength = Math.max(maxLength, strings[i].length());
            }

            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < maxLength; i++){
                for(int j = 0; j < 5; j++){
                    if(strings[j].length() > i)sb.append(strings[j].split("")[i]);
                }
            }
            System.out.println(sb);
        }catch(IOException e){

        }
    }
}
