package test;

public class six {
	public int solution(int[] arr1, int[] arr2) {
        if(arr1.length != arr2.length){
            return arr1.length > arr2.length ? 1 : -1;
        }else{
            int num1 = 0;
            int num2 = 0;
            for(int i = 0; i < arr1.length; i++){
                num1 += arr1[i];
                num2 += arr2[i];
            }
            
            return num1 == num2 ? 0 : num1 > num2 ? 1 : -1;
        }
    }
}
