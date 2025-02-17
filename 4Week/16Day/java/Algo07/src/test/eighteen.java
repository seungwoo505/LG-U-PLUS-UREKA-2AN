package test;

public class eighteen {
	public int solution(String[] order) {
		/**
		 * "iceamericano", "americanoice"	차가운 아메리카노
			"hotamericano", "americanohot"	따뜻한 아메리카노
			"icecafelatte", "cafelatteice"	차가운 카페 라테
			"hotcafelatte", "cafelattehot"	따뜻한 카페 라테
			"americano"	아메리카노
			"cafelatte"	카페 라테
			"anything"	아무거나
		 */
        int answer = 0;
        
        for(String s : order) {
        	answer += s.equals("iceamericano") || s.equals("americanoice") || s.equals("hotamericano") || s.equals("americanohot") || s.equals("americano") || s.equals("anything") ? 4500 : 5000;
        }
        return answer;
    }
}
