package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ten {
	public int solution(int a, int b, int c, int d) {
		Map<Integer, Integer> map = new HashMap<>();
		
		map.put(a, map.getOrDefault(a, 0) + 1);
		map.put(b, map.getOrDefault(b, 0) + 1);
		map.put(c, map.getOrDefault(c, 0) + 1);
		map.put(d, map.getOrDefault(d, 0) + 1);
		
		Set<Integer> key = map.keySet();
		
		if(key.size() == 1){
			return 1111 * a;
		}else if(key.size() == 2) {
			Object[] o = key.toArray();
			if(map.get(a) == 2) {
				int q = (int)o[0];
				int p = (int)o[1];
				
				return (q + p) * Math.abs(q - p);
			}else {
				int p = map.get(o[0]) == 3 ? (int)o[0] : (int)o[1];
				int q = map.get(o[0]) == 1 ? (int)o[0] : (int)o[1];
				return (int) Math.pow(10 * p + q, 2);
			}
		}else if (key.size() == 3) {
			Object[] o = key.toArray();
			return map.get(o[0]) == 2 ? (int)o[1] * (int)o[2] : map.get(o[1]) == 2 ? (int)o[0] * (int)o[2] : (int)o[0] * (int)o[1];
		}else {
			int min = 7;
			
			for(Integer i : key) {
				min = Math.min(i, min);
			}
			
			return min;
		}
    }
}
