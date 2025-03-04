import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Queue_10845{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> deque = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int n = 1; n <= N; n++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            String command = st.nextToken();

            if(command.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                deque.offer(num);
            }else if(command.equals("pop")){
                sb.append(deque.isEmpty() ? -1 : deque.poll())
                .append("\n");
            }else if(command.equals("size")){
                sb.append(deque.size())
                .append("\n");
            }else if(command.equals("empty")){
                sb.append(deque.isEmpty() ? 1 : 0)
                .append("\n");
            }else if(command.equals("front")){
                sb.append(deque.isEmpty() ? -1 : deque.peek())
                .append("\n");
            }else if(command.equals("back")){
                sb.append(deque.isEmpty() ? -1 : deque.peekLast())
                .append("\n");
            }
        }

        System.out.print(sb.toString());   
    }
}