package test2;

import java.util.Arrays;

public class fourteen {
	public int solution(int[] numbers) {
		Arrays.sort(numbers);
        return numbers[numbers.length - 1] * numbers[numbers.length - 2];
    }
}
