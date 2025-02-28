package test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertTest {

	public static void main(String[] args) {
		
		/**
		 * JDBC 6단계
		 */
		
		try {
			// 1. Driver 등록
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2. Connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ureka", "ureka", "ureka");
			
			// 3. Statement 생성
			PreparedStatement stmt = con.prepareStatement("INSERT INTO MEMBER(ID, PW, NAME, AGE) VALUES(?, ?, ?, ?)");
			// 값을 넣어야하는데 ? 안의 값을 매번 바꾸기엔 어려우므로 prepareStatement으로 바꾸기 편하게 변경
			
			// 4. SQL 전송
			stmt.setString(1, args[0]);
			stmt.setString(2, args[1]);
			stmt.setString(3, args[2]);
			stmt.setInt(4, Integer.parseInt(args[3]));
			
			int i = stmt.executeUpdate(); //select 외에 사용을 할 경우 executeUpdate 사용
			
			// 5. 결과 얻기
			System.out.println(i + "행이 변경되었습니다.");
			
			// 6. 자원 닫기
			stmt.close();
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
