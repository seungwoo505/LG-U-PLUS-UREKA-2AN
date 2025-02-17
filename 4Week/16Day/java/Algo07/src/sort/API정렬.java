package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class API정렬 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5, 3, 8, 1, 2};
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		List<String> names = new ArrayList<>();
		
        names.add("Bob");
        names.add("Charlie");
        names.add("Alice");
        
        // 리스트 정렬
        Collections.sort(names);
        
        // 정렬된 리스트 출력
        System.out.println("정렬된 리스트: " + names);
	}

}
