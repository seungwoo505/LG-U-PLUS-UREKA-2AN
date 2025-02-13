package exception;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 100;
		int y = 0;
		try {
			y = Integer.parseInt(args[0]);
		}catch(ArrayIndexOutOfBoundsException e) {
			//System.out.println("args[0]을 제공해야합니다.");
			//y = 1;
		}
		try {
			System.out.println(Divider.divide(x, y));
		}catch(MyException e) {
			System.out.println(e.getMessage());
		}
		/*
		catch(Exception e) { // 정교한 복구 불가능  <= 보안에 취약
			
		}
		*/
	}

}

class Divider {
	public static int divide(int x, int y) throws MyException {
		if(y == 0) {
			throw new MyException("0을 입력하지마세요.");
		}
		return x / y;
	}
}

class MyException extends Exception{

	public MyException(String message) {
		super(message);
	}
	
}