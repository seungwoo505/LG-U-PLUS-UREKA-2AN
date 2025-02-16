public class nine {
    public int solution(String A, String B) {
        StringBuilder sb = new StringBuilder(A);
        if(A.equals(B)){
                return 0;
            }

        for(int i = 1; i <= A.length(); i++){
            String s = String.valueOf(sb.charAt(sb.length() - 1));

            sb.deleteCharAt(sb.length() - 1);
            sb.insert(0, s);
            System.out.println(sb);

            if(sb.toString().equals(B)){
                return i;
            }
        }
        return -1;
    }
}
