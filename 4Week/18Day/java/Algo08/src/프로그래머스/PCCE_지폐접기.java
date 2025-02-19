package 프로그래머스;

public class PCCE_지폐접기 {
	public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        int billMin = Math.min(bill[0], bill[1]);
        int walletMin = Math.min(wallet[0], wallet[1]);
        int billMax = Math.max(bill[0], bill[1]);
        int walletMax = Math.max(wallet[0], wallet[1]);
        
        while(billMin > walletMin || billMax > walletMax) {
        	bill[ bill[0] > bill[1] ? 0 : 1 ] /= 2;
        	billMin = Math.min(bill[0], bill[1]);
        	billMax = Math.max(bill[0], bill[1]);
        	answer++;
        }
        return answer;
    }
}
