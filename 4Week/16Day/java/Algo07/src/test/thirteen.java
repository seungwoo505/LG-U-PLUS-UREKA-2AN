package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class thirteen {
	public int solution(String[] strArr) {
		Map<Integer, ArrayList<String>> map = new HashMap<>();
        int answer = 0;
        
        for(String s : strArr) {
        	ArrayList<String> str = map.get(s.length());
        	if(str == null) {
        		ArrayList<String> list = new ArrayList<>();
        		list.add(s);
        		map.put(s.length(), list);
        	}else {
        		str.add(s);
        		map.put(s.length(), str);
        	}
        }
        
        for(ArrayList<String> s : map.values()) {
        	if(answer < s.size()) {
        		answer = s.size();
        	}
        }
        return answer;
    }
}